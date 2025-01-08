package com.example.myfavoritebooksapp.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myfavoritebooksapp.data.model.Book

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToBookDetailsScreen: (Book) -> Unit,
    navigateToAddBookScreen: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("HOME SCREEN")
        Button(onClick = {
            navigateToBookDetailsScreen(Book(0, "", "", "", ""))
        }) { Text("BOOK DETAILS") }
        Button(onClick = {
            navigateToAddBookScreen()
        }) { Text("ADD BOOK") }
    }
}