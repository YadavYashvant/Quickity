package com.yashvant.org.apps.quickity.bill_feature.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yashvant.org.apps.quickity.MainActivity
import com.yashvant.org.apps.quickity.ui.theme.barlowext
import com.yashvant.org.apps.quickity.ui.theme.greenColor
import com.yashvant.org.apps.quickity.ui.theme.whiteV
import ro.alexmamo.roomjetpackcompose.presentation.books.components.AddBillAlertDialog
import ro.alexmamo.roomjetpackcompose.presentation.books.components.BillsContent
import ro.alexmamo.roomjetpackcompose.presentation.books.components.BillsTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BillsScreen(
    viewModel: BillsViewModel = hiltViewModel(),
    navigateToUpdateBillScreen: (billId: Int) -> Unit,
    mainActivity: MainActivity,
    payWithUpi: () -> Unit
) {
    val bills by viewModel.bills.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {
            BillsTopBar()
        },
        modifier = Modifier.padding(bottom = 70.dp),
        content = { padding ->
            BillsContent(
                padding = padding,
                bills = bills,
                deleteBill = { bill ->
                    viewModel.deleteBill(bill)
                },
                payWithUpi = payWithUpi,
                mainActivity = mainActivity,
                navigateToUpdateBillScreen = navigateToUpdateBillScreen
            )
            AddBillAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addBill = { bill->
                    viewModel.addBill(bill)
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(onClick = {
                payWithUpi()
            },
                icon = {
                    Icon(Icons.Outlined.ShoppingCart, contentDescription = "Pay")
                },
                text = {
                    Text(text = "Pay", fontSize = 20.sp, fontFamily = barlowext)
                },
                modifier = Modifier
                    .padding(16.dp)
                ,
                containerColor = greenColor,
                contentColor = whiteV

            )
        }
    )
}