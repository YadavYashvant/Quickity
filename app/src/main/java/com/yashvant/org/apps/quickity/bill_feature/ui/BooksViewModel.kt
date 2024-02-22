package com.yashvant.org.apps.quickity.bill_feature.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yashvant.org.apps.quickity.bill_feature.model.Book
import com.yashvant.org.apps.quickity.bill_feature.model.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val repo: BookRepository
) : ViewModel() {
    var book by mutableStateOf(Book(0, "", ""))
        private set
    var openDialog by mutableStateOf(false)

    val books = repo.getBooksFromRoom()

    fun getBook(id: Int) = viewModelScope.launch {
        book = repo.getBookFromRoom(id)
    }

    fun addBook(book: Book) = viewModelScope.launch {
        repo.addBookToRoom(book)
    }

    fun updateBook(book: Book) = viewModelScope.launch {
        repo.updateBookInRoom(book)
    }

    fun deleteBook(book: Book) = viewModelScope.launch {
        repo.deleteBookFromRoom(book)
    }

    fun updateTitle(title: String) {
        book = book.copy(
            title = title
        )
    }

    fun updateAuthor(author: String) {
        book = book.copy(
            author = author
        )
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }
}