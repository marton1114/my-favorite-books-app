package com.example.myfavoritebooksapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myfavoritebooksapp.data.model.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Query("SELECT * FROM BOOK_TABLE ORDER BY id ASC")
    fun getBooks(): Flow<List<Book>>

    @Query("SELECT * FROM BOOK_TABLE WHERE id = :id")
    suspend fun getBookById(id: Long): Book

    @Insert
    suspend fun addBook(book: Book)
}