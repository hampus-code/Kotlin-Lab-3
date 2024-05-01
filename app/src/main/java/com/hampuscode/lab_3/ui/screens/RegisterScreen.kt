package com.hampuscode.lab_3.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
@Preview(showBackground = true)
fun RegisterScreenPreview() {
    val navController = rememberNavController()
    val context = LocalContext.current

    RegisterScreen(navController = navController, context = context)
}
@Composable
fun RegisterScreen(navController: NavController, context: Context) {

    val enteredUsername = remember { mutableStateOf(TextFieldValue()) } //Remembering user input for username
    val enteredPassword = remember { mutableStateOf(TextFieldValue()) } //Remembering user input for password

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 150.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Register", modifier = Modifier.padding(),
            fontSize = 24.sp)

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            OutlinedTextField(
                leadingIcon = { Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = "") },
                trailingIcon = { Icon(imageVector = Icons.Outlined.Clear, contentDescription = "") },
                value = enteredUsername.value,
                onValueChange = { enteredUsername.value = it },
                label = { Text(text = "Username") },
                modifier = Modifier.padding(vertical = 10.dp)
            )

            OutlinedTextField(
                leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = "") },
                trailingIcon = { Icon(imageVector = Icons.Outlined.Clear, contentDescription = "") },
                value = enteredPassword.value
                , onValueChange = { enteredPassword.value = it },
                label = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.padding(vertical = 10.dp)
            )

            OutlinedTextField(
                leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = "") },
                trailingIcon = { Icon(imageVector = Icons.Outlined.Clear, contentDescription = "") },
                value = enteredPassword.value,
                onValueChange = { enteredPassword.value = it },
                label = { Text(text = "Confirm Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.padding(vertical = 10.dp)
            )

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Register")
            }

            Button(onClick = {
                navController.navigate("login_screen")
            }) {
                Text(text = "Back to Login")
            }

        }

    }
}