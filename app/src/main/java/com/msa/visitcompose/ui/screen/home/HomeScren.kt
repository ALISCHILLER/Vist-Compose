package com.msa.visitcompose.ui.screen.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen() {

    Text(
        text = "HomeScreen",
        textAlign = TextAlign.Center,
        fontSize = 32.sp,
        color = Color.Blue
    )

}