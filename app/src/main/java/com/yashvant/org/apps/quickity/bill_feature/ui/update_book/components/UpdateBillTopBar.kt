package ro.alexmamo.roomjetpackcompose.presentation.update_book.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateBillTopBar(
    navigateBack: () -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = "Update Bill",
            )
        },
        navigationIcon = {
            IconButton(
                onClick = navigateBack
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,
                )
            }
        }
    )
}