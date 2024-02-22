package com.yashvant.org.apps.quickity.bill_feature.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.yashvant.org.apps.quickity.bill_feature.model.Book
import com.yashvant.org.apps.quickity.bill_feature.model.Books
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Query("SELECT * FROM book_table ORDER BY id ASC")
    fun getBooks(): Flow<Books>

    @Query("SELECT * FROM book_table WHERE id = :id")
    suspend fun getBook(id: Int): Book

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBook(book: Book)

    @Update
    suspend fun updateBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)
}