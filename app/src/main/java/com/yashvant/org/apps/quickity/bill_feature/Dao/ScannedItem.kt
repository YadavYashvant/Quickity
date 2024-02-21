
package com.yashvant.org.apps.quickity.bill_feature.Dao

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update
import com.yashvant.org.apps.quickity.bill_feature.model.User
import kotlin.coroutines.coroutineContext

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT * FROM user WHERE id = :userId")
    suspend fun getUserById(userId: Int): User?
}

@Database(entities = [User::class], version = 1)
abstract class MyAppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: MyAppDatabase? = null

        fun getInstance(context: Context): MyAppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyAppDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}


/*
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
*/





