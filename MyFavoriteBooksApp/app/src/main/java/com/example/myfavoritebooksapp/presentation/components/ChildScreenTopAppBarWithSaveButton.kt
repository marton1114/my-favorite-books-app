package com.example.myfavoritebooksapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.myfavoritebooksapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChildScreenTopAppBarWithSaveButton(
    title: String,
    onArrowClick: () -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = onArrowClick) {
                Icon(
                    Icons.AutoMirrored.Default.ArrowBack,
                    stringResource(R.string.content_description_navigate_back_icon)
                )
            }
        },
        actions = {
            IconButton(
                onClick = onSaveClick,
//                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(
                    Icons.Default.Save,
                    stringResource(R.string.content_description_save_icon)
                )
            }
        },
        modifier = modifier
    )
}