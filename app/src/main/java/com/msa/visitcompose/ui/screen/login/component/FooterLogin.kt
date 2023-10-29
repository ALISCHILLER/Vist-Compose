package com.msa.visitcompose.ui.screen.login.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DesktopMac
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msa.visitcompose.ui.components.ButtonImageComponent
import com.msa.visitcompose.ui.components.shadow
import com.msa.visitcompose.ui.theme.BlueDark
import com.msa.visitcompose.ui.theme.Diamond
import com.msa.visitcompose.ui.theme.QuickSilver

@Composable
fun FooterLogin() {
    Card(
        shape = RoundedCornerShape(
            topEnd = 20.dp,
            topStart = 20.dp,
            bottomEnd = 0.dp,
            bottomStart = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .shadow(
                color = QuickSilver,
                offsetX = 0.3.dp,
                offsetY = 3.dp,
                spread = 3.dp,
                blurRadius = 24.0.dp
            ),
        border = BorderStroke(2.dp, Diamond),
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            ButtonImageComponent(
                modifier = Modifier
                    .padding(horizontal = 5.dp),
                text = "ویدئو آموزشی",
                color = BlueDark,
                imageVector = Icons.Default.DesktopMac,
                onClick = {}
            )
            ButtonImageComponent(
                modifier = Modifier
                    .padding(horizontal = 5.dp),
                text = "ویدئو آموزشی",
                color = BlueDark,
                imageVector = Icons.Default.DesktopMac,
                onClick = {}
            )
        }
    }
}
@Composable
@Preview
fun FooterLoginPreview() {
    FooterLogin()
}