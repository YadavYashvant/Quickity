package ro.alexmamo.roomjetpackcompose.presentation.books.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun TextTitle(
    billItem: String
) {
    Text(
        text = billItem,
        color = Color.DarkGray,
        fontSize = 25.sp
    )
}