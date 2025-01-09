package com.example.myfavoritebooksapp.presentation.screens.add_book

sealed interface AddBookEvent {
    data object OnSaveButtonClicked: AddBookEvent
    data object OnChangeCoverUrlInputDialogVisibility: AddBookEvent

    data class OnChangeTitleValue(val newValue: String): AddBookEvent
    data class OnChangeAuthorValue(val newValue: String): AddBookEvent
    data class OnChangeDescriptionValue(val newValue: String): AddBookEvent

    data class OnChangeCoverUrlValue(val newValue: String): AddBookEvent
    data class OnSetAsyncImageUrl(val url: String): AddBookEvent
}