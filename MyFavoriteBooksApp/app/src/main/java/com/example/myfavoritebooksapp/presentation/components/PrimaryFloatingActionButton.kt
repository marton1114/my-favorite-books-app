package com.example.myfavoritebooksapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeFloatingActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ExtendedFloatingActionButton(
        text = {
            Text(text)
        },
        icon = {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon")
        },
        onClick = onClick,
        modifier = modifier
    )
}