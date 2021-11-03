package com.bonehill.booklistmad.ui.book_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint:String="",
    //viewModel: BookListScreenViewModel = viewModel()

){
    var text by remember{
        mutableStateOf("")

    }
    var isHintDisplayed by remember{
        mutableStateOf(hint!="")
    }

    Column(modifier=modifier)
    {

        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                //onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    isHintDisplayed = !it.isFocused
                }
        )
        if (isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /*viewModel.loadPagedBooks()*/}, modifier = Modifier
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .align(Alignment.End)
        ) {
            Text(text = "Search")
        }
    }



}
