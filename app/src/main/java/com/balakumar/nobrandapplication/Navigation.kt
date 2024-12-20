package com.balakumar.nobrandapplication

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
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
            val index =it.arguments?.getString("index")?:"0"
            val Index = index.toInt()
            navController.currentBackStackEntry?.arguments?.apply {
                putInt("index",Index)
            }
            CategoryScreen(navController = navController, innerPadding = innerPadding)
        }
        composable(NavigationRoute.ItemScreen.route) {
            val index = it.arguments?.getString("index")?:"0"
            val Index =index.toInt()
            val id = it.arguments?.getString("id")?:"0"
            val Id = id.toInt()
            navController.currentBackStackEntry?.arguments?.apply {
                putInt("index",Index)
                putInt("id",Id)
            }
            ItemScreen(navController)
        }
    }
}