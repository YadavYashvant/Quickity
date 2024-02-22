package ro.alexmamo.roomjetpackcompose.presentation.books.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun AddBillFloatingActionButton(
    openDialog: () -> Unit
) {
    FloatingActionButton(
        onClick = openDialog
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "add bill"
        )
    }
}