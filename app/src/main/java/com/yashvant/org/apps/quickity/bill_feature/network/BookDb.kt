package com.yashvant.org.apps.quickity.bill_feature.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yashvant.org.apps.quickity.bill_feature.Dao.BookDao
import com.yashvant.org.apps.quickity.bill_feature.model.Book

@Database(
    entities = [Book::class],
    version = 1,
    exportSchema = false
)
abstract class BookDb : RoomDatabase() {
    abstract val bookDao: BookDao
}