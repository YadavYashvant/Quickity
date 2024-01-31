
package com.yashvant.org.apps.quickity.bill_feature.entity

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@Entity(tableName = "bill_table")
data class BillEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val itemName: String,
    val itemPrice: Double
)

data class Item(val name: String, val price: Double)

@Database(entities = [BillEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun billDao(): BillDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
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

@Dao
interface BillDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBill(billEntity: BillEntity)

    @Query("SELECT * FROM bill_table")
    suspend fun getAllBills(): List<BillEntity>
}

class BillRepository(private val billDao: BillDao) {
    suspend fun insertBill(billEntity: BillEntity) {
        billDao.insertBill(billEntity)
    }

    suspend fun getAllBills(): List<BillEntity> {
        return billDao.getAllBills()
    }
}

class BillViewModel(private val repository: BillRepository) : ViewModel() {
    private val _bills = MutableStateFlow<List<BillEntity>>(emptyList())
    val bills: StateFlow<List<BillEntity>> = _bills

    fun addBill(item: Item) {
        viewModelScope.launch {
            val billEntity = BillEntity(itemName = item.name, itemPrice = item.price)
            repository.insertBill(billEntity)
            _bills.value = repository.getAllBills()
        }
    }
}





