package com.yashvant.org.apps.quickity.bill_feature.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*@Entity(tableName = "bill_table")
data class Bill(
    val id: Long,
    val itemName: String,
)*/

@Entity
data class User(
    @PrimaryKey val id: Int,
    val name: String,
    val email: String
)

