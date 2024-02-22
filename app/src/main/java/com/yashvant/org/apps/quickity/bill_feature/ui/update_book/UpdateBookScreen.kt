package ro.alexmamo.roomjetpackcompose.presentation.update_book

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.yashvant.org.apps.quickity.bill_feature.ui.BooksViewModel
import ro.alexmamo.roomjetpackcompose.presentation.update_book.components.UpdateBookContent
import ro.alexmamo.roomjetpackcompose.presentation.update_book.components.UpdateBookTopBar

@Composable
fun UpdateBookScreen(
    viewModel: BooksViewModel = hiltViewModel(),
    bookId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getBook(bookId)
    }
    Scaffold(
        topBar = {
            UpdateBookTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateBookContent(
                padding = padding,
                book = viewModel.book,
                updateTitle = { title ->
                    viewModel.updateTitle(title)
                },
                updateAuthor = { author ->
                    viewModel.updateAuthor(author)
                },
                updateBook = { book ->
                    viewModel.updateBook(book)
                },
                navigateBack = navigateBack
            )
        }
    )
}