package com.yashvant.org.apps.quickity.bill_feature.ui

import androidx.compose.runtime.Composable

/*@Composable
fun BillScreen(viewModel: UserViewModel) {
    Column {
        TextField(
            value = viewModel.name.value,
            onValueChange = viewModel::onNameChange,
            placeholder = { Text("Enter name") }
        )
        TextField(
            value = viewModel.email.value,
            onValueChange = viewModel::onEmailChange,
            placeholder = { Text("Enter email") }
        )
        Button(onClick = viewModel::onSaveClicked) {
            Text("Save User")
        }
    }

    Spacer(modifier = Modifier.weight(1f))

    List(viewModel.users.value) { user ->
        UserListItem(user)
    }
}*/

/*import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.yashvant.org.apps.quickity.bill_feature.entity.AppDatabase
import com.yashvant.org.apps.quickity.bill_feature.entity.BillEntity
import com.yashvant.org.apps.quickity.bill_feature.entity.BillRepository
import com.yashvant.org.apps.quickity.bill_feature.entity.BillViewModel
import com.yashvant.org.apps.quickity.bill_feature.entity.Item
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BillList(viewModel: BillViewModel = viewModel()) {
    val bills by viewModel.bills.collectAsState()

    LazyColumn {
        items(bills) { bill ->
            BillCard(bill)
        }
    }
}

@Composable
fun BillCard(bill: BillEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            Text(text = bill.itemName)
            Text(text = bill.itemPrice.toString())
        }
    }
}

@Composable
fun GenerateBillButton(viewModel: BillViewModel = viewModel()) {
    Button(
        onClick = {
            viewModel.addBill(Item("Sample Item", 10.0))
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text("Generate Bill") // To be replaced with a QR code scanner
    }
}


class MyApp : Application() {
    val database by lazy { AppDatabase.getInstance(this) }
    val repository by lazy { BillRepository(database.billDao()) }
    val viewModel by lazy { BillViewModel(repository) }
}

@Composable
fun MyAppContent(app: MyApp) {
    Column {
        GenerateBillButton(app.viewModel)
        BillList(app.viewModel)
    }
}

@Composable
fun MyAppBill() {
    val app = remember { MyApp() }

    MyAppContent(app)
}*/
