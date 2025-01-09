package com.example.myfavoritebooksapp.presentation.screens.home.components

import androidx.collection.emptyLongSet
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardDoubleArrowRight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myfavoritebooksapp.R

@Composable
fun BookListComponent(
    bookListItem: BookListItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val borderStroke: Dp =
        if (bookListItem.isPalindrome)
            1.dp
        else
            -1.dp
    val color =
        if (bookListItem.isPalindrome)
            MaterialTheme.colorScheme.primaryContainer
        else
            MaterialTheme.colorScheme.surfaceContainer

    val containerColor =
        if (bookListItem.isPalindrome)
            MaterialTheme.colorScheme.primary
        else
            MaterialTheme.colorScheme.onSurface

    Surface(
        onClick = onClick,
        color = color,
        contentColor = containerColor,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(borderStroke, MaterialTheme.colorScheme.primary)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp, 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AsyncImage(
                model = bookListItem.book.coverUrl,
                contentDescription = stringResource(R.string.content_description_book_cover),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = bookListItem.book.title,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.weight(1F))

            Icon(Icons.Default.KeyboardDoubleArrowRight,
                stringResource(R.string.content_description_book_list_component))
        }
    }
}