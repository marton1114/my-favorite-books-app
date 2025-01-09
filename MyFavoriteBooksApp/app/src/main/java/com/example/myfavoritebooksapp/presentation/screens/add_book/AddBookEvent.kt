package com.example.myfavoritebooksapp.presentation.screens.add_book

sealed interface AddBookEvent {
    data object onSaveButtonClicked: AddBookEvent
    data object onChangeCoverUrlInputDialogVisibility: AddBookEvent

    data class onChangeTitleValue(val newValue: String): AddBookEvent
    data class onChangeAuthorValue(val newValue: String): AddBookEvent
    data class onChangeDescriptionValue(val newValue: String): AddBookEvent

    data class onChangeCoverUrlValue(val newValue: String): AddBookEvent
    data class onSetAsyncImageUrl(val url: String): AddBookEvent
}