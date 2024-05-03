package com.hampuscode.lab_3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.hampuscode.lab_3.ui.components.Books
import com.hampuscode.lab_3.user.UserRepository


@Composable
fun UserLoggedInScreen(navController: NavController, username: String, userRepository: UserRepository) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Welcome $username")
        Text(text = "Down below you can search for your favourite books" +
                " and then add them to your list")

    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Books()
    }



}