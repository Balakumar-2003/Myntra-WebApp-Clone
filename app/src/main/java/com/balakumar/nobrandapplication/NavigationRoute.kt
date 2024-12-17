package com.balakumar.nobrandapplication

sealed class NavigationRoute(val route :String) {
    object HomeScreen:NavigationRoute(route = "HomeScreen")
    object SearchScreen:NavigationRoute(route = "SearchScreen")
    object CategoryScreen:NavigationRoute(route = "CategoryScreen")
}