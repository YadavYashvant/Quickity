package com.yashvant.org.apps.quickity.bill_feature.model

import kotlinx.coroutines.flow.Flow

typealias Bills = List<Bill>

interface BillRepository {
    fun getBillsFromRoom(): Flow<Bills>

    suspend fun getBillFromRoom(id: Int): Bill

    suspend fun addBillToRoom(bill: Bill)

    suspend fun updateBillInRoom(bill: Bill)

    suspend fun deleteBillFromRoom(bill: Bill)
}