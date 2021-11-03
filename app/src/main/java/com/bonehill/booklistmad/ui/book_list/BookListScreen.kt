package com.bonehill.booklistmad.ui.book_list

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bonehill.booklistmad.ui.composables.BookItem


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
                hint="Enter title...",
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
fun BookList(viewModel: BookListScreenViewModel = viewModel()) {
    val bookList by remember { viewModel.bookList }
    val endReached by remember { viewModel.endReached }
    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }
    
    LazyColumn(contentPadding = PaddingValues( 16.dp)){
         items(bookList.size){
            if(it >= bookList.size - 1 && !endReached)
            {
                viewModel.loadPagedBooks()
            }
             BookItem(bookList[it])
         }
    }
}


