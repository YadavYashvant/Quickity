package com.yashvant.org.apps.quickity.bill_feature.model

import com.yashvant.org.apps.quickity.bill_feature.Dao.BillDao

class BillRepositoryImpl(
    private val billDao: BillDao
) : BillRepository {
    override fun getBillsFromRoom() = billDao.getBills()

    override suspend fun getBillFromRoom(id: Int) = billDao.getBill(id)

    override suspend fun addBillToRoom(bill: Bill) = billDao.addBill(bill)

    override suspend fun updateBillInRoom(bill: Bill) = billDao.updateBill(bill)

    override suspend fun deleteBillFromRoom(bill: Bill) = billDao.deleteBill(bill)
}