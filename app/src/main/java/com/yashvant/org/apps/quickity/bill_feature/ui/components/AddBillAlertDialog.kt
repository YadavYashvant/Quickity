package ro.alexmamo.roomjetpackcompose.presentation.books.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.yashvant.org.apps.quickity.bill_feature.model.Bill
import kotlinx.coroutines.job

@Composable
fun AddBillAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addBill: (bill: Bill) -> Unit
) {
    if (openDialog) {
        var item by remember { mutableStateOf("") }
        var price by remember { mutableStateOf("") }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = "Add a new bill"
                )
            },
            text = {
                Column {
                    TextField(
                        value = item,
                        onValueChange = { item = it },
                        placeholder = {
                            Text(
                                text = "Item name"
                            )
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = price,
                        onValueChange = { price = it },
                        placeholder = {
                            Text(
                                text = "Price"
                            )
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val bill = Bill(0, item, price)
                        addBill(bill)
                    }
                ) {
                    Text(
                        text = "Add"
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(
                        text = "Cancel"
                    )
                }
            }
        )
    }
}