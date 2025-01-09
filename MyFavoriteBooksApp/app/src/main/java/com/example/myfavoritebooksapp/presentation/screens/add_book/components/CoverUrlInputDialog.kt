package com.example.myfavoritebooksapp.presentation.screens.add_book.components

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun CoverUrlInputDialog(
    coverUrlValue: String = "",
    onCoverUrlValueChange: (newValue: String) -> Unit,
    onDismissRequest: () -> Unit,
    onSubmit: (value: String) -> Unit,
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color.White,
            modifier = Modifier.padding(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Add meg az URL-t",
                    style = MaterialTheme.typography.headlineMedium
                )

                OutlinedTextField(
                    value = coverUrlValue,
                    onValueChange = onCoverUrlValueChange,
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    placeholder = {
                        Text("e.g. https://humanitas.ro/assets/images/products/Anna-Karenina.jpg")
                    }
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {
                    OutlinedButton(onClick = onDismissRequest) {
                        Text("Mégse")
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    FilledTonalButton(onClick = {
                        onSubmit(coverUrlValue)
                        onDismissRequest()
                    }) {
                        Text("Kész")
                    }
                }
            }
        }
    }
}