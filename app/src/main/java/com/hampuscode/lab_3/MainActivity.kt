package com.hampuscode.lab_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.hampuscode.lab_3.database.MyDatabase
import com.hampuscode.lab_3.navigation.ComposeNavigation
import com.hampuscode.lab_3.ui.screens.LoginScreen
import com.hampuscode.lab_3.ui.theme.Lab_3Theme
import com.hampuscode.lab_3.user.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val userRepository = UserRepository(MyDatabase.getInstance(applicationContext), CoroutineScope(
            Dispatchers.IO))
        setContent {
            Lab_3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ComposeNavigation(context = this, userRepository = userRepository)
                }
            }
        }

    }
}
