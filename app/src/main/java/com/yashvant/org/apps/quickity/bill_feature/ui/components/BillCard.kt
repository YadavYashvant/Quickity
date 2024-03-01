package ro.alexmamo.roomjetpackcompose.presentation.books.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yashvant.org.apps.quickity.bill_feature.model.Bill

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BillCard(
    bill: Bill,
    deleteBill: () -> Unit,
    navigateToUpdateBillScreen: (billId: Int) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        onClick = {
            navigateToUpdateBillScreen(bill.id)
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                TextItem(
                    billItem = bill.Item
                )
                TextPrice(
                    billPrice = bill.price
                )
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            DeleteIcon(
                deleteBill = deleteBill
            )
        }
    }
}