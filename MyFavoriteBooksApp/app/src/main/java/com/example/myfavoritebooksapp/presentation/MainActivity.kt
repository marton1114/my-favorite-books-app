package com.example.myfavoritebooksapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.myfavoritebooksapp.presentation.navigation.NavGraph
import com.example.myfavoritebooksapp.presentation.theme.MyFavoriteBooksAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            MyFavoriteBooksAppTheme {
                NavGraph(navController = navController)
            }
        }
    }
}