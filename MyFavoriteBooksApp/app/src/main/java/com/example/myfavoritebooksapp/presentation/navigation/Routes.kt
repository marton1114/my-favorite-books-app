package com.example.myfavoritebooksapp.presentation.navigation

import com.example.myfavoritebooksapp.data.model.Book
import kotlinx.serialization.Serializable

@Serializable
object AddBookRoute

@Serializable
object HomeRoute

@Serializable
data class BookDetailsRoute(
    val id: Long,
    val title: String,
    val author: String,
    val description: String,
    val coverUrl: String
)

fun BookDetailsRoute.toBook() = Book(
    id = this.id,
    title = this.title,
    author = this.author,
    description = this.description,
    coverUrl = this.coverUrl
)
