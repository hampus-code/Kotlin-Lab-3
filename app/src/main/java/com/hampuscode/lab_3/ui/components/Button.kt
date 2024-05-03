package com.hampuscode.lab_3.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MyButton(
    text: String,
    textColor: Color = Color.White,
    backgroundColor: Color = Color.Blue,
    roundedRadius: Dp = 8.dp,
    onClick: () -> Unit
) {
    
    Text(text = text)

}