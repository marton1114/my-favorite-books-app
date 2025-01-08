package com.example.myfavoritebooksapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "BOOK_TABLE")
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val author: String,
    val description: String,
    val coverUrl: String
)