package com.yashvant.org.apps.quickity.bill_feature.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.yashvant.org.apps.quickity.bill_feature.model.Bill
import com.yashvant.org.apps.quickity.bill_feature.model.Bills
import kotlinx.coroutines.flow.Flow

@Dao
interface BillDao {
    @Query("SELECT * FROM bill_table ORDER BY id ASC")
    fun getBills(): Flow<Bills>

    @Query("SELECT * FROM bill_table WHERE id = :id")
    suspend fun getBill(id: Int): Bill

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBill(bill: Bill)

    @Update
    suspend fun updateBill(bill: Bill)

    @Delete
    suspend fun deleteBill(bill: Bill)
}