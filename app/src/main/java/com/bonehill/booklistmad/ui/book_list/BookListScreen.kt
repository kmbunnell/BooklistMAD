package com.bonehill.booklistmad.ui.book_list


import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bonehill.booklistmad.ui.composables.BookItem


@ExperimentalComposeUiApi
@Composable
fun BookListScreen(
){

    Surface(
        color= MaterialTheme.colors.background,
       modifier = Modifier.fillMaxSize()
   ){
        Column() {
            Spacer(modifier = Modifier.height(20.dp))
            SearchBar(
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))
            BookList()
        }

    }
}


@Composable
fun BookList(viewModel: BookListScreenViewModel = hiltViewModel()
) {
    val bookList by remember { viewModel.bookList }
    val endReached by remember { viewModel.endReached }
    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }
    val tagList by remember { viewModel.tagList}

    LazyColumn(contentPadding = PaddingValues( 16.dp)){

         items(bookList.size){

             Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically

             )
             {
                 if (it >= bookList.size - 1 && !endReached && !isLoading) {
                     viewModel.loadPagedBooks()
                 }

                 BookItem(bookList[it])

                 Spacer(modifier = Modifier.width(8.dp))

                 /*TagSection(
                     tags = tagList,
                     onCheckChange={ selected: Boolean, id: Byte ->

                     var k = selected
                     var d = id
                 })*/
             }
         }
    }

    Box( contentAlignment = Alignment.Center,
    modifier = Modifier.fillMaxSize()) {
        if (isLoading) {
            CircularProgressIndicator(color = Color.Cyan)
        }
        if (loadError.isNotEmpty()) {
            //create error composable
        }
    }
}


