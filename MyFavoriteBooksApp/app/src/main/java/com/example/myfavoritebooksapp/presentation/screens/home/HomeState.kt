package com.example.myfavoritebooksapp.presentation.screens.home

import com.example.myfavoritebooksapp.presentation.screens.home.components.BookListItem

data class HomeState(
    val books: List<BookListItem> = emptyList(),
    val isLoading: Boolean = true,
)