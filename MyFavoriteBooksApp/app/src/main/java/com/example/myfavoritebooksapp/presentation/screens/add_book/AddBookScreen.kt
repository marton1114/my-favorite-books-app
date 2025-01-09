package com.example.myfavoritebooksapp.presentation.screens.add_book

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myfavoritebooksapp.presentation.components.ChildScreenTopAppBarWithSaveButton
import com.example.myfavoritebooksapp.presentation.screens.add_book.components.CoverUrlInputDialog
import com.example.myfavoritebooksapp.presentation.screens.add_book.components.rememberImeState

@Composable
fun AddBookScreen(
    viewModel: AddBookViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    val state = viewModel.state

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = imeState.value) {
        if (imeState.value){
            scrollState.animateScrollTo(scrollState.maxValue, tween(300))
        }
    }

    Scaffold(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures { focusManager.clearFocus() }
        },
        topBar = {
            ChildScreenTopAppBarWithSaveButton(
                title = "Új könyv hozzáadása",
                onArrowClick =  { navigateBack() },
                onSaveClick =  {
                    viewModel.onEvent(AddBookEvent.OnSaveButtonClicked)
//                    navigateBack()
                }
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
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AnimatedVisibility(state.errorMessage.isNotEmpty()) {
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.error),
                        contentColor = MaterialTheme.colorScheme.error,
                        color = MaterialTheme.colorScheme.errorContainer,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) { Text(state.errorMessage, modifier = Modifier.padding(8.dp)) }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.33F, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "Borító",
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Box (
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .fillMaxSize()
                                .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(4.dp)),
                            contentAlignment = Alignment.Center,
                        ) {
                            if (state.asyncImageUrl != "") {
                                AsyncImage(
                                    model = state.asyncImageUrl,
                                    contentScale = ContentScale.FillWidth,
                                    contentDescription = "Book Cover",
                                    alpha = 0.65F,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .fillMaxSize()
                                        .clip(RoundedCornerShape(4.dp)),
                                )
                            }

                            IconButton(
                                onClick = {
                                    viewModel.onEvent(AddBookEvent.OnChangeCoverUrlInputDialogVisibility)
                                },
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .fillMaxSize()
                            ) {
                                Icon(
                                    Icons.Default.AddCircleOutline, "Add Book Icon",
                                    modifier = Modifier.size(72.dp)
                                )
                            }
                        }
                    }

                    Column(
                        modifier = Modifier.weight(0.66F),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Cím",
                            style = MaterialTheme.typography.bodyLarge
                        )

                        OutlinedTextField(
                            value = state.titleValue,
                            onValueChange = { newValue ->
                                viewModel.onEvent(AddBookEvent.OnChangeTitleValue(newValue))
                            },
                            placeholder = { Text("A könyv címe") },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .focusRequester(focusRequester),
                            keyboardOptions = KeyboardOptions(
                                imeAction = ImeAction.Next
                            ),
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            )
                        )

                        Text(
                            text = "Szerző",
                            style = MaterialTheme.typography.bodyLarge
                        )

                        OutlinedTextField(
                            value = state.authorValue,
                            onValueChange = { newValue ->
                                viewModel.onEvent(AddBookEvent.OnChangeAuthorValue(newValue))
                            },
                            placeholder = { Text("A könyv szerzője") },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .focusRequester(focusRequester),
                            keyboardOptions = KeyboardOptions(
                                imeAction = ImeAction.Next
                            ),
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            )
                        )
                    }
                }

                Text(
                    text = "Leírás",
                    style = MaterialTheme.typography.bodyLarge
                )

                OutlinedTextField(
                    value = state.descriptionValue,
                    onValueChange = { newValue ->
                        viewModel.onEvent(AddBookEvent.OnChangeDescriptionValue(newValue))
                    },
                    placeholder = { Text("A könyv leírása") },
                    minLines = 3,
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                            viewModel.onEvent(AddBookEvent.OnSaveButtonClicked)
                            navigateBack()
                        }
                    )
                )
            }
        }

        if (state.isCoverUrlInputDialogVisible) {
            CoverUrlInputDialog(
                coverUrlValue = state.coverUrlValue,
                onCoverUrlValueChange = { viewModel.onEvent(AddBookEvent.OnChangeCoverUrlValue(it)) },
                onDismissRequest = { viewModel.onEvent(AddBookEvent.OnChangeCoverUrlInputDialogVisibility) },
                onSubmit = {
                    viewModel.onEvent(AddBookEvent.OnSetAsyncImageUrl(it))
                }
            )
        }
    }
}