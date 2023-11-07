package com.msa.visitcompose.ui.screen.setting

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun SettingScreen() {
    Text(
        text = "SettingScreen",
        textAlign = TextAlign.Center,
        fontSize = 32.sp,
        color = Color.Blue
    )
}

@Preview
@Composable
fun SettingScreenPreview() {
    SettingScreen()
}