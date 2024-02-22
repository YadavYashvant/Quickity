package com.yashvant.org.apps.quickity.bill_feature.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yashvant.org.apps.quickity.bill_feature.model.Bill
import com.yashvant.org.apps.quickity.bill_feature.model.BillRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BillsViewModel @Inject constructor(
    private val repo: BillRepository
) : ViewModel() {
    var bill by mutableStateOf(Bill(0, "", ""))
        private set
    var openDialog by mutableStateOf(false)

    val bills = repo.getBillsFromRoom()

    fun getBill(id: Int) = viewModelScope.launch {
        bill = repo.getBillFromRoom(id)
    }

    fun addBill(bill: Bill) = viewModelScope.launch {
        repo.addBillToRoom(bill)
    }

    fun updateItem(bill: Bill) = viewModelScope.launch {
        repo.updateBillInRoom(bill)
    }

    fun deleteBill(bill: Bill) = viewModelScope.launch {
        repo.deleteBillFromRoom(bill)
    }

    fun updateItem(Item: String) {
        bill = bill.copy(
            Item = Item
        )
    }

    fun updatePrice(price: String) {
        bill = bill.copy(
            price = price
        )
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }
}