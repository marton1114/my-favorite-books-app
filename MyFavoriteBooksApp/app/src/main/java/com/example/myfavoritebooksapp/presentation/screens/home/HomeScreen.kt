package com.example.myfavoritebooksapp.presentation.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myfavoritebooksapp.R
import com.example.myfavoritebooksapp.data.model.Book
import com.example.myfavoritebooksapp.presentation.components.HomeFloatingActionButton
import com.example.myfavoritebooksapp.presentation.screens.home.components.BookListComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToBookDetailsScreen: (Book) -> Unit,
    navigateToAddBookScreen: () -> Unit,
) {
    val state = viewModel.state

    LaunchedEffect(Unit) {
        viewModel.onEvent(HomeEvent.OnRefreshBookList)
    }

    Scaffold(
        topBar = { CenterAlignedTopAppBar({ Text(stringResource(R.string.my_favorite_books_title_label))}) },
        floatingActionButton = { HomeFloatingActionButton(stringResource(R.string.floating_action_button_new_book_label), { navigateToAddBookScreen() }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.number_of_books_label, state.books.size),
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.weight(1F))
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                ) {
                    Text(
                        stringResource(R.string.palindrome_explanation_label),
                        modifier = Modifier.padding(2.dp))
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(state.books) { bookListItem ->
                    BookListComponent(
                        bookListItem = bookListItem,
                        onClick = { navigateToBookDetailsScreen(bookListItem.book) }
                    )
                }
            }
        }

    }
}