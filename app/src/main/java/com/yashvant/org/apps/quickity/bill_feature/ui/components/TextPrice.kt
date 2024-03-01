package ro.alexmamo.roomjetpackcompose.presentation.books.components


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun TextPrice(
    billPrice: String
) {
    Text(
        text = "$billPrice",
        color = Color.DarkGray,
        fontSize = 16.sp,

    )
}