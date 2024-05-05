package com.hampuscode.lab_3.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.hampuscode.lab_3.R
import com.hampuscode.lab_3.composables.Books
import com.hampuscode.lab_3.user.UserRepository


@Composable
fun UserLoggedInScreen(navController: NavController, username: String, userRepository: UserRepository) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            //Background image
            painter = painterResource(id = R.drawable.blank_old_paper),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Welcome $username")
            Text(
                text = "Down below you can search for your favourite books" +
                        " and then add them to your list"
            )

        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Books()

        }
    }

}