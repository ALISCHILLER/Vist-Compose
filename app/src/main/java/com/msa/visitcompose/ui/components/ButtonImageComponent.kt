package com.msa.visitcompose.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DesktopMac
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msa.visitcompose.ui.theme.BlueDark
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ButtonImageComponent(
    modifier: Modifier,
    text: String,
    color: Color,
    imageVector: ImageVector,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Icon(
            modifier = Modifier.padding(horizontal = 5.dp),
            imageVector = imageVector,
            contentDescription = ""
        )
        Text(
            text = text,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun ButtonImageComponentPreview() {
    ButtonImageComponent(
        modifier = Modifier
            .padding(horizontal = 5.dp),
        text = "ویدئو آموزشی",
        color = BlueDark,
        imageVector = Icons.Default.DesktopMac
    ) {

    }
}

