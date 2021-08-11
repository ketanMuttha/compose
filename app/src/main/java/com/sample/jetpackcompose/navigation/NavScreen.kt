package com.sample.jetpackcompose.navigation

sealed class NavScreen(val route: String) {
    object LoginScreen: NavScreen("login_screen")
    object HomeScreen: NavScreen("home_screen")

    fun withArgs(vararg args: String) : String {
        return buildString {
            append(route)
            args.forEach { it ->
                append("/$it")
            }
        }
    }
}
