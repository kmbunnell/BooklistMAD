package com.bonehill.booklistmad.ui.book_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bonehill.booklistmad.data.api.Book
import com.bonehill.booklistmad.data.repository.BookRepository
import com.bonehill.booklistmad.data.repository.Resource
import com.bonehill.booklistmad.util.Constants.PAGE_SIZE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookListScreenViewModel @Inject constructor(
    private val repository: BookRepository
): ViewModel () {

    private var currentPage=0
    var bookList = mutableStateOf<List<Book>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)
    private var searchText:String = ""

    fun setSearchText(text:String)
    {
        searchText=text
    }

    fun loadPagedBooks()
    {
        isLoading.value=true
        viewModelScope.launch {
            when(val result=repository.getBookListByTitle( searchText, currentPage* PAGE_SIZE, PAGE_SIZE ))
            {
                is Resource.Success -> {
                    endReached.value = currentPage * PAGE_SIZE >= result.data.totalItems
                    bookList.value += result.data.items

                    currentPage++
                    loadError.value=""
                    isLoading.value=false
                }

                is Resource.Failed -> {
                    loadError.value=result.message
                    isLoading.value=false
                }
            }
        }
    }
}