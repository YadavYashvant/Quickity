package ro.alexmamo.roomjetpackcompose.presentation.update_book

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.yashvant.org.apps.quickity.bill_feature.ui.BillsViewModel
import ro.alexmamo.roomjetpackcompose.presentation.update_book.components.UpdateBillContent
import ro.alexmamo.roomjetpackcompose.presentation.update_book.components.UpdateBillTopBar

@Composable
fun UpdateBillScreen(
    viewModel: BillsViewModel = hiltViewModel(),
    billId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getBill(billId)
    }
    Scaffold(
        topBar = {
            UpdateBillTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateBillContent(
                padding = padding,
                bill = viewModel.bill,
                updateItem = { title ->
                    viewModel.updateItem(title)
                },
                updatePrice = { author ->
                    viewModel.updatePrice(author)
                },
                updateBill = { book ->
                    viewModel.updateItem(book)
                },
                navigateBack = navigateBack
            )
        }
    )
}