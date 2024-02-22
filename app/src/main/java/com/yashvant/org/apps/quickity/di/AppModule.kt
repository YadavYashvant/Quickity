package com.yashvant.org.apps.quickity.di

import android.content.Context
import androidx.room.Room
import com.yashvant.org.apps.quickity.bill_feature.Dao.BillDao
import com.yashvant.org.apps.quickity.bill_feature.model.BillRepository
import com.yashvant.org.apps.quickity.bill_feature.model.BillRepositoryImpl
import com.yashvant.org.apps.quickity.bill_feature.network.BillDb
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
        BillDb::class.java,
        "book_table"
    ).build()

    @Provides
    fun provideBookDao(
        billDb: BillDb
    ) = billDb.billDao

    @Provides
    fun provideBookRepository(
        billDao: BillDao
    ): BillRepository = BillRepositoryImpl(
        billDao = billDao
    )
}