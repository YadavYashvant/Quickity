package ro.alexmamo.roomjetpackcompose.presentation.books.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BillsTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Bills", fontSize = 24.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            )
        }
    )
}