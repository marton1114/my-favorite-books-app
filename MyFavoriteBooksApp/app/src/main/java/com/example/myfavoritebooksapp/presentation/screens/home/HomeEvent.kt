package com.example.myfavoritebooksapp.presentation.screens.home

sealed interface HomeEvent {
    data object OnRefreshBookList: HomeEvent
}