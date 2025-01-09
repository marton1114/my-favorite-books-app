package com.example.myfavoritebooksapp.presentation.screens.add_book

data class AddBookState(
    val titleValue: String = "",
    val authorValue: String = "",
    val descriptionValue: String = "",

    val coverUrlValue: String = "",

    val asyncImageUrl: String = "",

    val errorMessage: String = "",

    val isCoverUrlInputDialogVisible: Boolean = false,
)