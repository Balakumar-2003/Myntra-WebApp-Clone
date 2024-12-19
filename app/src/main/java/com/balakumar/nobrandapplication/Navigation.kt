package com.balakumar.nobrandapplication

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController,viewModel: HomeScreenViewModel,innerPadding:PaddingValues){
    NavHost(navController=navController, startDestination = NavigationRoute.HomeScreen.route){
        composable(NavigationRoute.HomeScreen.route){
            HomeScreen(navcontroller = navController, innerPadding = innerPadding, viewModel = viewModel)
        }
        composable(NavigationRoute.SearchScreen.route) {
            SearchScreen(navcontroller = navController, innerPadding = innerPadding)
        }
        composable(NavigationRoute.CategoryScreen.route) {
            CategoryScreen(navController = navController, innerPadding = innerPadding)
        }
    }

}