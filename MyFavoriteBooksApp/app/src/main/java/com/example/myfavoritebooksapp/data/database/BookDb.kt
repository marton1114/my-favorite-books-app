package com.example.myfavoritebooksapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myfavoritebooksapp.data.dao.BookDao
import com.example.myfavoritebooksapp.data.model.Book

@Database(
    entities = [Book::class],
    version = 1,
    exportSchema = false
)
abstract class BookDb : RoomDatabase() {
    abstract val bookDao: BookDao
}