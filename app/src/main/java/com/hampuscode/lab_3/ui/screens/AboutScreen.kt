package com.hampuscode.lab_3.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hampuscode.lab_3.R
import com.hampuscode.lab_3.ui.components.CustomButton
import com.hampuscode.lab_3.ui.components.CustomText

@Composable
fun AboutScreen(navController: NavController) {

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
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 100.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CustomText(text = "This is an app where you can search for all kind of books " +
                    "in an API library. In further development in a future version," +
                    " it is intended that you as a user will be able to add your favorite books to your own list." +
                    " So stay tuned for more! ", modifier = Modifier.padding(horizontal = 50.dp))
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 100.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            CustomButton(
                text = "Back to Home",
                onClick = {navController.navigate("home_screen")
                })

            CustomButton(
                text = "Login", onClick = {
                navController.navigate("login_screen")
            })
        }

    }
    
}