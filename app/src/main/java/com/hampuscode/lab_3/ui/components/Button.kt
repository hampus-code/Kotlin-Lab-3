package com.hampuscode.lab_3.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val buttonColor = Color(0xFF477ad8)


@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(8.dp),
        shape = ButtonDefaults.shape,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor, contentColor = Color.White)
    ) {
        Text(text = text)
    }
}