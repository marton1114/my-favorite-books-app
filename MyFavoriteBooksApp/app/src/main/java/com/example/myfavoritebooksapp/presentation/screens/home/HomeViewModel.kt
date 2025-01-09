package com.example.myfavoritebooksapp.presentation.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfavoritebooksapp.data.repository.BookRepository
import com.example.myfavoritebooksapp.presentation.screens.home.components.BookListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: BookRepository
) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set

    init {
        getBookList()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.onRefreshBookList -> {
                getBookList()
            }
        }
    }

    fun String.containsPalindrome(): Boolean {
        val cleaned = this.replace(Regex("\\s+"), " ").lowercase()
        for (word in cleaned.split(" ")) {
            println(word)
            if (word == word.reversed())
                return true
        }
        return false
    }

    private fun getBookList() = viewModelScope.launch(Dispatchers.IO) {
        state = state.copy(isLoading = true)
        repository.getBookList().collect{ response ->

            val bookItems = response.map { book ->
                BookListItem(
                    book = book,
                    isPalindrome = book.title.containsPalindrome()
                )
            }

            state = state.copy(
                books = bookItems,
                isLoading = false,
            )
        }
    }
}