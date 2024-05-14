package com.hampuscode.lab_3.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hampuscode.lab_3.ui.screens.AboutScreen
import com.hampuscode.lab_3.ui.screens.HomeScreen
import com.hampuscode.lab_3.ui.screens.LoginScreen
import com.hampuscode.lab_3.ui.screens.RegisterScreen
import com.hampuscode.lab_3.ui.screens.SearchBooksScreen
import com.hampuscode.lab_3.ui.screens.UserLoggedInScreen
import com.hampuscode.lab_3.user.UserRepository
import com.hampuscode.lab_3.viewModel.BookViewModel

@Composable
fun ComposeNavigation(context: Context, userRepository: UserRepository) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home_screen" //This is HomeScreen
    ) {
        composable("home_screen") {
            HomeScreen(navController = navController)
        }
        composable("about_screen") {
            AboutScreen(navController = navController)
        }
        composable("login_screen") {
            LoginScreen(navController = navController, context = context, userRepository = userRepository)
        }
        composable("register_screen") {
            RegisterScreen(navController = navController, context = context, userRepository = userRepository)
        }
        composable("user-logged-in-screen/{username}") { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: ""
            UserLoggedInScreen(navController, username, userRepository)
        }
        composable("search_books_screen") {
            SearchBooksScreen(navController = navController)
        }
    }
}