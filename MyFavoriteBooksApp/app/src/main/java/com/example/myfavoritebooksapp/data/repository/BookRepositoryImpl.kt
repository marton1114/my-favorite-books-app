package com.example.myfavoritebooksapp.data.repository

import com.example.myfavoritebooksapp.data.dao.BookDao
import com.example.myfavoritebooksapp.data.model.Book

class BookRepositoryImpl(private val bookDao: BookDao) : BookRepository {
    override fun getBookList() = bookDao.getBooks()

    override suspend fun getBookById(id: Long) = bookDao.getBookById(id)

    override suspend fun addBook(book: Book) = bookDao.addBook(book)
}