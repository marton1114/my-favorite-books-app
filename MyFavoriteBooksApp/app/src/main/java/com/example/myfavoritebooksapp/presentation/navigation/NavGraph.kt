package com.example.myfavoritebooksapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.myfavoritebooksapp.data.model.toBookDetailsRoute
import com.example.myfavoritebooksapp.presentation.screens.add_book.AddBookScreen
import com.example.myfavoritebooksapp.presentation.screens.book_details.BookDetailsScreen
import com.example.myfavoritebooksapp.presentation.screens.home.HomeScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> {
            HomeScreen(
                navigateToBookDetailsScreen = { book ->
                    navController.navigate(book.toBookDetailsRoute())
                },
                navigateToAddBookScreen = { navController.navigate(AddBookRoute) }
            )
        }
        composable<BookDetailsRoute> { stackEntry ->
            val book = stackEntry.toRoute<BookDetailsRoute>().toBook()
            BookDetailsScreen(
                book = book,
                navigateBack = { navController.navigateUp() }
            )
        }
        composable<AddBookRoute> {
            AddBookScreen(
                navigateBack = { navController.navigateUp() }
            )
        }
    }
}