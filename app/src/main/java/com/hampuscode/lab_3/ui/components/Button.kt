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
val buttonColorRed = Color(0xFFA02E01)
val buttonColorGold = Color(0xFFC69E4E)
val buttonColorBrown = Color(0xFF532B13)




@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = ButtonDefaults.shape,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColorBrown, contentColor = Color.White)
    ) {
        Text(text = text)
    }
}