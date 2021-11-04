package com.bonehill.booklistmad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bonehill.booklistmad.ui.Navigation.BottomNavItem
import com.bonehill.booklistmad.ui.Navigation.BottomNavigationBar
import com.bonehill.booklistmad.ui.Navigation.Navigation
import com.bonehill.booklistmad.ui.book_list.BookListScreen
import com.bonehill.booklistmad.ui.book_list.SearchBar
import com.bonehill.booklistmad.ui.theme.BooklistMADTheme
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Modifier


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BooklistMADTheme {
                val navController= rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Search",
                                    route= "book_list_screen",
                                    icon= Icons.Default.Search
                                ),
                                BottomNavItem(
                                    name = "Sort",
                                    route= "book_sort_screen",
                                    icon= Icons.Default.Info
                                )
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(navController=navController)
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {


}