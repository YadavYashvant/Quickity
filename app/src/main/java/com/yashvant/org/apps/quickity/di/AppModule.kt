package com.yashvant.org.apps.quickity.di

import android.content.Context
import androidx.room.Room
import com.yashvant.org.apps.quickity.bill_feature.Dao.BookDao
import com.yashvant.org.apps.quickity.bill_feature.model.BookRepository
import com.yashvant.org.apps.quickity.bill_feature.model.BookRepositoryImpl
import com.yashvant.org.apps.quickity.bill_feature.network.BookDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideBookDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        BookDb::class.java,
        "book_table"
    ).build()

    @Provides
    fun provideBookDao(
        bookDb: BookDb
    ) = bookDb.bookDao

    @Provides
    fun provideBookRepository(
        bookDao: BookDao
    ): BookRepository = BookRepositoryImpl(
        bookDao = bookDao
    )
}