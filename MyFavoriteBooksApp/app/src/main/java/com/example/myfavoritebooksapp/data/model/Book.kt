package com.example.myfavoritebooksapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myfavoritebooksapp.presentation.navigation.BookDetailsRoute


@Entity(tableName = "BOOK_TABLE")
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val author: String,
    val description: String,
    val coverUrl: String
)

fun Book.toBookDetailsRoute() = BookDetailsRoute(
    id = this.id,
    title = this.title,
    author = this.author,
    description = this.description,
    coverUrl = this.coverUrl
)