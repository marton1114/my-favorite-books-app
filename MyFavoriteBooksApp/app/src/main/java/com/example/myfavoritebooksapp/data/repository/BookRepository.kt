package com.example.myfavoritebooksapp.data.repository

import com.example.myfavoritebooksapp.data.model.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun getBookList(): Flow<List<Book>>

    suspend fun getBookById(id: Long): Book?

    suspend fun addBook(book: Book)
}