package com.example.myfavoritebooksapp.presentation.screens.book_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myfavoritebooksapp.data.model.Book
import com.example.myfavoritebooksapp.presentation.components.ChildScreenTopAppBar

@Composable
fun BookDetailsScreen(
    book: Book,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            ChildScreenTopAppBar(
                title = "Könyv részletei",
                onClick =  { navigateBack() },
            )
        },
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AsyncImage(
                        model = book.coverUrl,
                        contentDescription = "Book Cover",
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.5F)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.FillWidth,
                    )

                    Column(
                        modifier = Modifier
                            .weight(0.5F)
                    ) {
                        Text(
                            text = book.title,
                            fontWeight = FontWeight.Bold,
                            maxLines = 2,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = book.author,
                            fontWeight = FontWeight.Medium,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                Text(
                    text = book.description,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}