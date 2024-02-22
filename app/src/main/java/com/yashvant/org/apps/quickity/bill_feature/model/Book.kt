package com.yashvant.org.apps.quickity.bill_feature.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val author: String
)