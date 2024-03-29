package ro.alexmamo.roomjetpackcompose.presentation.books.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

@Composable
fun DeleteIcon(
    deleteBill: () -> Unit
) {
        IconButton(
            onClick = deleteBill,
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete bill icon",
            )
        }
}