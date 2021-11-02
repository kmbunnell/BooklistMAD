package com.bonehill.booklistmad.ui.Navigation

sealed class Screen(val route: String)
{
    object BookListScreen:Screen("book_list_screen")
    object BookSortScreen:Screen ("book_sort_screen")
}
