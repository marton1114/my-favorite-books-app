package com.example.myfavoritebooksapp.presentation.screens.add_book

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfavoritebooksapp.data.model.Book
import com.example.myfavoritebooksapp.data.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddBookViewModel @Inject constructor(
    private val repository: BookRepository
) : ViewModel() {
    var state by mutableStateOf(AddBookState())
        private set

    fun onEvent(event: AddBookEvent) {
        when (event) {
            is AddBookEvent.onSaveButtonClicked -> {
                val book = Book(0L, state.titleValue, state.authorValue, state.descriptionValue,
                    state.coverUrlValue)
                state = state.copy(
                    errorMessage = getBookValidationErrorMessage(book)
                )

                if (state.errorMessage.isEmpty()) {
                    addBook(book)
                    state = state.copy(
                        errorMessage = ""
                    )
                }
            }
            is AddBookEvent.onChangeTitleValue -> {
                state = state.copy(titleValue = event.newValue)
            }
            is AddBookEvent.onChangeAuthorValue -> {
                state = state.copy(authorValue = event.newValue)
            }
            is AddBookEvent.onChangeDescriptionValue -> {
                state = state.copy(descriptionValue = event.newValue)
            }
            is AddBookEvent.onChangeCoverUrlValue -> {
                state = state.copy(coverUrlValue = event.newValue)
            }
            is AddBookEvent.onSetAsyncImageUrl -> {
                state = state.copy(asyncImageUrl = event.url)
            }
            is AddBookEvent.onChangeCoverUrlInputDialogVisibility -> {
                state = state.copy(isCoverUrlInputDialogVisible = ! state.isCoverUrlInputDialogVisible)
            }
        }
    }

    private fun getBookValidationErrorMessage(book: Book): String {
        var errorMessage = ""
        if (book.title.isBlank() || book.author.isBlank() ||
            book.description.isBlank() || book.coverUrl.isBlank()) {
            errorMessage += "Tölts ki minden mezőt!"
        }
        if (false) {
            errorMessage += "\nA könyvborító url-je érvénytelen!"
        }
        return errorMessage
    }

    private fun addBook(book: Book) = viewModelScope.launch(Dispatchers.IO) {
        repository.addBook(book)
    }
}