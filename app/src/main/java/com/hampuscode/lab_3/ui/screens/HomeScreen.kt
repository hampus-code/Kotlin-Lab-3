package com.hampuscode.lab_3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    val navController = rememberNavController()

    HomeScreen(navController = navController)
}
@Composable
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 100.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Welcome to Book Vault",
            modifier = Modifier.padding(bottom = 200.dp))

        Button(onClick = {
            navController.navigate("login_screen")
        }) {
        Text(text = "Login/Register")
        }
    }



}