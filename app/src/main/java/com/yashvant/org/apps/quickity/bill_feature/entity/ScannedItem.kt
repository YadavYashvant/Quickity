package com.yashvant.org.apps.quickity.bill_feature.entity

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity
data class ScannedItem(
    @PrimaryKey(autoGenerate = true) val itemId: Int = 0,
    val itemName: String,
    val itemPrice: Double
)

// ScannedItemDao.kt
@Dao
interface ScannedItemDao {
    @Insert
    suspend fun insertItem(item: ScannedItem)

    @Query("SELECT * FROM ScannedItem")
    suspend fun getAllItems(): List<ScannedItem>
}

// AppDatabase.kt
@Database(entities = [ScannedItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scannedItemDao(): ScannedItemDao
}

