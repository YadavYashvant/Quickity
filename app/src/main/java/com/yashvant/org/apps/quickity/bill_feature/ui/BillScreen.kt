package com.yashvant.org.apps.quickity.bill_feature.ui

import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import com.yashvant.org.apps.quickity.bill_feature.entity.DatabaseClient
import com.yashvant.org.apps.quickity.bill_feature.entity.Item
import kotlinx.coroutines.flow.internal.NoOpContinuation.context

@Composable
fun BillScreen() {
    FloatingActionButton(onClick = {
        // Add items to the database
        val item1 = Item(name = "Item 1", price = 10)
        val item2 = Item(name = "Item 2", price = 20)
        DatabaseClient.getInstance(context).itemDao().insert(item1)
        DatabaseClient.getInstance(context).itemDao().insert(item2)

        // Generate the bill
        val items = listOf(item1, item2)
        val totalAmount = items.sumBy { it.price }
        val bill = Bill(items = items, totalAmount = totalAmount)
        DatabaseClient.getInstance(context).billDao().insert(bill)

        // Notify the caller that a new bill has been generated
        onBillGenerated(bill)
    }) {
        Text("Add Items and Generate Bill")
    }
}

/*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import com.yashvant.org.apps.quickity.bill_feature.entity.ScannedItem
import com.yashvant.org.apps.quickity.bill_feature.entity.ScannedItemViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.withContext


@Composable
fun BillScreen(viewModel: ScannedItemViewModel) {
    val items by viewModel.allItems.collectAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // UI components to display scanned items
        items.forEach { item ->
            Text(text = "Item Name: ${item.itemName}")
            Text(text = "Description: ${item.itemDescription}")
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Button to add a new item
        Button(onClick = {
            val newItem = ScannedItem(
                itemName = "New Item",
                itemDescription = "Description for the new item"
            )
            viewModel.insertItem(newItem)
        }) {
            Text("Add New Item")
        }
    }
}
*/


/*
@Composable
fun BillScreen() {
    val context = LocalContext.current
    */
/*val database = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "app-database"
    ).build()*//*


    val database = InventoryDatabase.getDatabase(context)
    val viewModel = ScannedItemViewModel(InventoryRepository(database.itemDao()))
    val coroutineScope = rememberCoroutineScope()

    // Use ZXing or another library to capture scanned data

    // For simplicity, let's assume you have scannedItemName and scannedItemPrice
    val scannedItem = ScannedItem(itemName = "Example Item", itemPrice = 9.99)

    // Insert the scanned item into the Room database
    LaunchedEffect(key1 = scannedItem) {
        withContext(Dispatchers.IO) {
            viewModel.insertItem(scannedItem)
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
            scannedItems = viewModel.getAllItems()
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
}*/
