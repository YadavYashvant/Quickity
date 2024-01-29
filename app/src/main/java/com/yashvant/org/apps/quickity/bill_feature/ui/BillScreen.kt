package com.yashvant.org.apps.quickity.bill_feature.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
    val totalAmount = remember {
        LaunchedEffect(key1 = Unit) {
            withContext(Dispatchers.IO) {
                calculateTotalAmount(database.scannedItemDao().getAllItems())
            }
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
        // Add more Compose components as needed
    }
}

// Utility function to calculate total amount
suspend fun calculateTotalAmount(scannedItems: List<ScannedItem>): Double {
    return scannedItems.sumByDouble { it.itemPrice }
}