package com.hampuscode.lab_3.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
@Preview(showBackground = true)
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 150.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Login", modifier = Modifier.padding(),
            fontSize = 24.sp)

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            OutlinedTextField(
                leadingIcon = { Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = "") },
                trailingIcon = { Icon(imageVector = Icons.Outlined.Clear, contentDescription = "")},
                value = "Username", onValueChange = {},
                label = { Text(text = "Username")},
                modifier = Modifier.padding(vertical = 10.dp),


            )

            //TODO - Make the clear icon on password and eye instead. And when i hold on the eye you can see the password

            OutlinedTextField(
                leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = "")},
                trailingIcon = { Icon(imageVector = Icons.Outlined.Clear, contentDescription = "")},
                value = "Password", onValueChange = {},
                label = { Text(text = "Password")},
                visualTransformation = PasswordVisualTransformation(),

            )

            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Don't have an account? Register here",
                    textDecoration = TextDecoration.Underline)
            }

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Login")
            }

        }

    }
}