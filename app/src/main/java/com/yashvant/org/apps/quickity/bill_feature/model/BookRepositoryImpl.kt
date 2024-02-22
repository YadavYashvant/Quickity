package com.yashvant.org.apps.quickity.bill_feature.model

import com.yashvant.org.apps.quickity.bill_feature.Dao.BookDao

class BookRepositoryImpl(
    private val bookDao: BookDao
) : BookRepository {
    override fun getBooksFromRoom() = bookDao.getBooks()

    override suspend fun getBookFromRoom(id: Int) = bookDao.getBook(id)

    override suspend fun addBookToRoom(book: Book) = bookDao.addBook(book)

    override suspend fun updateBookInRoom(book: Book) = bookDao.updateBook(book)

    override suspend fun deleteBookFromRoom(book: Book) = bookDao.deleteBook(book)
}