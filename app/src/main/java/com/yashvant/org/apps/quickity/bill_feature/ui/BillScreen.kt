package com.yashvant.org.apps.quickity.bill_feature.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room
import com.yashvant.org.apps.quickity.bill_feature.entity.AppDatabase
import com.yashvant.org.apps.quickity.bill_feature.entity.ScannedItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.withContext


@Composable
fun BillScreen() {
    val context = LocalContext.current
    val database = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "app-database"
    ).build()

    // Use ZXing or another library to capture scanned data

    // For simplicity, let's assume you have scannedItemName and scannedItemPrice
    val scannedItem = ScannedItem(itemName = "Example Item", itemPrice = 9.99)

    // Insert the scanned item into the Room database
    LaunchedEffect(key1 = scannedItem) {
        withContext(Dispatchers.IO) {
            database.scannedItemDao().insertItem(scannedItem)
        }
    }

    // Display the total bill amount
    var totalAmount by remember { mutableStateOf(0.0) }

    // Add scanned items to a list for display
    var scannedItems by remember { mutableStateOf(emptyList<ScannedItem>()) }

    // LaunchedEffect to fetch data and update UI
    LaunchedEffect(key1 = Unit) {
        withContext(Dispatchers.IO) {
            // Fetch scanned items
            scannedItems = database.scannedItemDao().getAllItems()

            // Calculate total amount
            totalAmount = calculateTotalAmount(scannedItems)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Total Amount: $${String.format("%.2f", totalAmount)}", fontSize = 20.sp)

        // Display scanned items in cards
        scannedItems.forEach { item ->
            CardItem(item = item)
        }

        lateinit var newItem: ScannedItem

        // Button to add a new card
        Button(onClick = {
            // Add a new scanned item to the list and Room database
            newItem = ScannedItem(itemName = "New Item", itemPrice = 5.99)
            scannedItems = scannedItems + newItem
        },
            ) {
            Text("Add New Item")
            LaunchedEffect(key1 = newItem) {
                withContext(Dispatchers.IO) {
                    database.scannedItemDao().insertItem(newItem)
                }
            }
        }
    }
}
// Composable for displaying a card item
@Composable
fun CardItem(item: ScannedItem) {
    // Customize the appearance of the card as needed
    Text("Item: ${item.itemName}, Price: $${item.itemPrice}", fontSize = 16.sp)
}

// Utility function to calculate total amount
suspend fun calculateTotalAmount(scannedItems: List<ScannedItem>): Double {
    return scannedItems.sumByDouble { it.itemPrice }
}