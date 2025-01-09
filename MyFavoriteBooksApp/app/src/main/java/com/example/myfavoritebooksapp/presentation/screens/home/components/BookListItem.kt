package com.example.myfavoritebooksapp.presentation.screens.home.components

import com.example.myfavoritebooksapp.data.model.Book

data class BookListItem(
    val book: Book,
    val isPalindrome: Boolean
)