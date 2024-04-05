package com.yashvant.org.apps.quickity.bill_feature.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yashvant.org.apps.quickity.MainActivity
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
        /*floatingActionButton = {
            AddBillFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }*/
    )
}