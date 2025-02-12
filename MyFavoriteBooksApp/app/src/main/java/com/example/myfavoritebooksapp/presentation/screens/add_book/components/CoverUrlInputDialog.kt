package com.example.myfavoritebooksapp.presentation.screens.add_book.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.myfavoritebooksapp.R

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
                    text = stringResource(R.string.cover_url_input_dialog_label),
                    style = MaterialTheme.typography.headlineMedium
                )

                OutlinedTextField(
                    value = coverUrlValue,
                    onValueChange = onCoverUrlValueChange,
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    placeholder = {
                        Text(stringResource(R.string.cover_url_input_dialog_placeholder))
                    }
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {
                    OutlinedButton(onClick = onDismissRequest) {
                        Text(stringResource(R.string.cancel_button_label))
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    FilledTonalButton(onClick = {
                        onSubmit(coverUrlValue)
                        onDismissRequest()
                    }) {
                        Text(stringResource(R.string.submit_button_label))
                    }
                }
            }
        }
    }
}