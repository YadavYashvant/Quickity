package com.yashvant.org.apps.quickity.bill_feature.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bill_table")
data class Bill(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val Item: String,
    val price: String
)