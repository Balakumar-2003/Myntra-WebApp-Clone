package com.balakumar.nobrandapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController,viewModel: HomeScreenViewModel){
    NavHost(navController=navController, startDestination = NavigationRoute.HomeScreen.route){
        composable(NavigationRoute.HomeScreen.route){
            Home(navController,viewModel)
        }
        composable(NavigationRoute.SearchScreen.route) {
            SearchScreen(navController)
        }
        composable(NavigationRoute.CategoryScreen.route) {
            CategoryScreen(navController)
        }
    }

}