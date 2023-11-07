package com.msa.visitcompose.ui.screen.report

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ReportScreen() {
    Text(
        text = "ReportScreen",
        textAlign = TextAlign.Center,
        fontSize = 32.sp,
        color = Color.Blue
    )
}


@Composable
@Preview
fun ReportScreenPreview() {
    ReportScreen()
}