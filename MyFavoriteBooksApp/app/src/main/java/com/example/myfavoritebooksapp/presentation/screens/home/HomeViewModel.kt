package com.example.myfavoritebooksapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.example.myfavoritebooksapp.data.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: BookRepository
) : ViewModel() {

}