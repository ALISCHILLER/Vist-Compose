@file:OptIn(ExperimentalMaterial3Api::class)

package com.msa.visitcompose.ui.screen.login


import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msa.visitcompose.ui.components.LinearGradient
import com.msa.visitcompose.ui.dialog.roundedCircularProgress.DownloadButtonDialog
import com.msa.visitcompose.ui.screen.login.component.FooterLogin
import com.msa.visitcompose.ui.screen.login.component.HeaderLogin
import com.msa.visitcompose.ui.screen.login.component.LoginSection
import com.msa.visitcompose.ui.theme.*
import com.msa.visitcompose.ui.theme.VisitComposeTheme


@Composable
fun LoginScreen(
    onEvent: (LoginEvent) -> Unit
) {

    val progress = remember {
        Animatable(0f)
    }
    var startDownload by remember {
        mutableStateOf(true)
    }
    var hideDatePicker by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Diamond),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            HeaderLogin()
            Spacer(modifier = Modifier.height(15.dp))
            LinearGradient()
            Spacer(modifier = Modifier.height(15.dp))
            LoginSection(
                modifier = Modifier.align(CenterHorizontally)
            ) {
                hideDatePicker = true
            }
        }
        FooterLogin()

        if (hideDatePicker) {
            DownloadButtonDialog(
                strokeColor = MaterialTheme.colorScheme.onPrimary,
                strokeSize = 8.dp,
                progressAll = progress.value,
                modifier = Modifier.size(300.dp)
            )

            if (progress.value ==100f)
                onEvent(LoginEvent.SaveAppEntry)

            LaunchedEffect(key1 = startDownload) {
                if (startDownload) {
                    progress.animateTo(
                        1f,
                        tween(6000, 800)
                    )
                } else {
                    progress.snapTo(0f)
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
@Preview(showBackground = true)
fun LoginScreenPreview() {
    VisitComposeTheme {
        LoginScreen(
            {}
        )
    }

}