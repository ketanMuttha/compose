package com.sample.jetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.sample.jetpackcompose.ui.HomeScreen
import com.sample.jetpackcompose.ui.LoginScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavScreen.LoginScreen.route) {
        composable(route = NavScreen.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(
            route = NavScreen.HomeScreen.route + "/{name}", // optional "?name={name}
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "hello"
                    nullable = true
                }
            )
        ) { entry ->
            HomeScreen(name = entry.arguments?.getString("name"))
        }

    }
}
