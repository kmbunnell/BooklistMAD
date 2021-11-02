package com.bonehill.booklistmad.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bonehill.booklistmad.ui.BookSortScreen
import com.bonehill.booklistmad.ui.book_list.BookListScreen

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination =  Screen.BookListScreen.route )
    {
        composable(Screen.BookListScreen.route)
        {
            BookListScreen()
        }
        composable(Screen.BookSortScreen.route)
        {
            BookSortScreen()
        }
    }
}