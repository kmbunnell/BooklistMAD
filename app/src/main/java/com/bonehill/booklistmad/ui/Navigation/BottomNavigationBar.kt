package com.bonehill.booklistmad.ui.Navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text


import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(
    items:List<BottomNavItem>,
    navController: NavController,
    modifier:  Modifier = Modifier,
    onItemClick: (BottomNavItem)->Unit
)
{
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation (
        modifier = modifier,
        backgroundColor = Color.Cyan,
        elevation = 5.dp
    ){
        items.forEach{ item ->
            val selected= item.route==backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                selectedContentColor= Color.Black,
                unselectedContentColor=Color.Gray,
                onClick = { onItemClick(item) },
                icon ={
                    Column (
                        horizontalAlignment=CenterHorizontally
                            ) {

                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name
                        )

                        Text(
                            text=item.name,
                            textAlign = TextAlign.Center,
                            fontSize = 10.sp
                        )



                    }
                }
            )
        }
    }
}