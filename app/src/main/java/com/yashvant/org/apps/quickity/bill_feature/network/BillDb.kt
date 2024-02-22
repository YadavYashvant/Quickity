package com.yashvant.org.apps.quickity.bill_feature.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yashvant.org.apps.quickity.bill_feature.Dao.BillDao
import com.yashvant.org.apps.quickity.bill_feature.model.Bill

@Database(
    entities = [Bill::class],
    version = 1,
    exportSchema = false
)
abstract class BillDb : RoomDatabase() {
    abstract val billDao: BillDao
}