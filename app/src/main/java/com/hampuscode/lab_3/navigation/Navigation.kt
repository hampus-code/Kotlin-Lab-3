package com.hampuscode.lab_3.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hampuscode.lab_3.ui.screens.HomeScreen
import com.hampuscode.lab_3.ui.screens.LoginScreen
import com.hampuscode.lab_3.ui.screens.RegisterScreen

@Composable
fun ComposeNavigation(context: Context) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home_screen" //This is HomeScreen
    ) {
        composable("home_screen") {
            HomeScreen(navController = navController)
        }
        composable("log_in_screen") {
            LoginScreen(navController = navController, context = context)
        }
        composable("register_screen") {
            RegisterScreen(navController = navController, context = context)
        }
    }
}