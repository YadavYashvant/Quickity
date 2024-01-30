package com.yashvant.org.apps.quickity.bill_feature.entity

import android.content.Context
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


@Entity(tableName = "scanned_items")
data class ScannedItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val itemName: String,
    val itemDescription: String
)

@Dao
interface ScannedItemDao {

    @Query("SELECT * FROM scanned_items")
    fun getAllItems(): Flow<List<ScannedItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ScannedItem)

    // Additional methods...

}

@Database(entities = [ScannedItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun scannedItemDao(): ScannedItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

class ScannedItemRepository(private val scannedItemDao: ScannedItemDao) {

    val allItems: Flow<List<ScannedItem>> = scannedItemDao.getAllItems()

    suspend fun insertItem(item: ScannedItem) {
        scannedItemDao.insertItem(item)
    }

    // Additional methods...

    suspend fun getAllItems(): Flow<List<ScannedItem>> {
        return scannedItemDao.getAllItems()
    }


}

class ScannedItemViewModel(private val repository: ScannedItemRepository) : ViewModel() {

    val allItems: Flow<List<ScannedItem>> = repository.allItems

    fun insertItem(item: ScannedItem) {
        viewModelScope.launch {
            repository.insertItem(item)
        }
    }

    // Additional methods...
}

