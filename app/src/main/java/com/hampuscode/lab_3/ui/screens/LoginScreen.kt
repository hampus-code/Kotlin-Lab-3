package com.hampuscode.lab_3.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hampuscode.lab_3.R
import com.hampuscode.lab_3.ui.components.CustomButton
import com.hampuscode.lab_3.user.UserRepository


@Composable
fun LoginScreen(navController: NavController, context: Context, userRepository: UserRepository) {

    //Remembering user input for username and when rotating the screen
    val enteredUsername = rememberSaveable { mutableStateOf("") }

    //Remembering user input for password and when rotating the screen
    val enteredPassword = rememberSaveable { mutableStateOf("") }


    val users by userRepository.findAllUsers().collectAsState(initial = emptyList())


    Box(
        modifier = Modifier.fillMaxSize()
        // TODO// - .verticalScroll(rememberScrollState())
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
                .verticalScroll(rememberScrollState())
                .padding(vertical = 150.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Login", modifier = Modifier.padding(),
                fontSize = 24.sp
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                OutlinedTextField(
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.AccountCircle,
                            contentDescription = ""
                        )
                    },
                    value = enteredUsername.value,
                    onValueChange = { enteredUsername.value = it },
                    label = { Text(text = "Username") },
                    modifier = Modifier.padding(vertical = 10.dp),


                    )

                OutlinedTextField(
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = ""
                        )
                    },
                    value = enteredPassword.value,
                    onValueChange = { enteredPassword.value = it },
                    label = { Text(text = "Password") },
                    visualTransformation = PasswordVisualTransformation(),

                    )

                TextButton(onClick = {
                    navController.navigate("register_screen")
                }) {
                    Text(
                        text = "Don't have an account? Register here",
                        textDecoration = TextDecoration.Underline
                    )
                }

                CustomButton(text = "Login", onClick = {
                    val username = enteredUsername.value
                    val password = enteredPassword.value

                    val user = users.find { it.userName == username && it.password == password }
                    if (user != null) {
                        navController.navigate("user-logged-in-screen/${user.userName}")
                    } else {
                        //If login is incorrect the Toast shows
                        Toast.makeText(
                            context,
                            "Incorrect username or password, please try again.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                })

            }

        }
    }
}