package com.hampuscode.lab_3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun RegisterScreen() {
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
                value = "Username", onValueChange = {},
                label = { Text(text = "Username") },
                modifier = Modifier.padding(vertical = 10.dp)
            )

            OutlinedTextField(
                leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = "") },
                trailingIcon = { Icon(imageVector = Icons.Outlined.Clear, contentDescription = "") },
                value = "Password", onValueChange = {},
                label = { Text(text = "Password") }
            )

        }

    }
}