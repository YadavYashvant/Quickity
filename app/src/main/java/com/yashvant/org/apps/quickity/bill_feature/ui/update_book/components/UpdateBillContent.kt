package ro.alexmamo.roomjetpackcompose.presentation.update_book.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yashvant.org.apps.quickity.bill_feature.model.Bill

@Composable
fun UpdateBillContent(
    padding: PaddingValues,
    bill: Bill,
    updateItem: (item: String) -> Unit,
    updatePrice: (price: String) -> Unit,
    updateBill: (bill: Bill) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = bill.Item,
            onValueChange = { title ->
                updateItem(title)
            },
            placeholder = {
                Text(
                    text = "Item name"
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        TextField(
            value = bill.price,
            onValueChange = { author ->
                updatePrice(author)
            },
            placeholder = {
                Text(
                    text = "Price"
                )
            }
        )
        Button(
            onClick = {
                updateBill(bill)
                navigateBack()
            }
        ) {
            Text(
                text = "Update"
            )
        }
    }
}