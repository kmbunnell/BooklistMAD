package com.bonehill.booklistmad.ui.book_list

import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester

import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel


@ExperimentalComposeUiApi
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint:String="",
    viewModel: BookListScreenViewModel = hiltViewModel()
) {
    var text by remember {

        mutableStateOf("")
    }

    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = text,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),

        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = { viewModel.loadPagedBooks()
                        focusManager.clearFocus()}
        ),
        onValueChange = { text = it },
        maxLines = 1,
        singleLine = true,
        textStyle = TextStyle(color = Color.Black),
        label = {

            Text("Title")

        }
    )


}
