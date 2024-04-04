package ro.alexmamo.roomjetpackcompose.presentation.books.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yashvant.org.apps.quickity.bill_feature.model.Bill
import com.yashvant.org.apps.quickity.bill_feature.model.Bills

@Composable
@ExperimentalMaterial3Api
fun BillsContent(
    padding: PaddingValues,
    bills: Bills,
    deleteBill: (bill: Bill) -> Unit,
    navigateToUpdateBillScreen: (billId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding).padding()
    ) {
        items(
            items = bills,
        ) { bill ->
            BillCard(
                bill = bill,
                deleteBill = {
                    deleteBill(bill)
                },
                navigateToUpdateBillScreen = navigateToUpdateBillScreen
            )
        }
    }
}