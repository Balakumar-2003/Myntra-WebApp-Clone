package com.balakumar.nobrandapplication

sealed class NavigationRoute(val route :String) {
    data object HomeScreen:NavigationRoute(route = "HomeScreen")
    data object SearchScreen:NavigationRoute(route = "SearchScreen")
    data object CategoryScreen:NavigationRoute(route = "CategoryScreen/{index}")
    data object ItemScreen:NavigationRoute(route = "ItemScreen/{index}/{id}")
}