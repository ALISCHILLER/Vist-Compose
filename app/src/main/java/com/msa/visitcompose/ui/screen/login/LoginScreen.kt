@file:OptIn(ExperimentalMaterial3Api::class)

package com.msa.visitcompose.ui.screen.login


import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
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
    val startDownload by remember {
        mutableStateOf(true)
    }
    var hideDatePicker by remember {
        mutableStateOf(false)
    }

    var presses by remember { mutableIntStateOf(0) }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
               Column {
                   HeaderLogin()
                   Spacer(modifier = Modifier.height(15.dp))
                   LinearGradient()
               }
            },
            bottomBar = {
                FooterLogin()
                        },
        ) { innerPadding ->
            LoginSection(
                modifier = Modifier.padding(innerPadding)
            ) {
                hideDatePicker = true
            }
            if (hideDatePicker) {
                DownloadButtonDialog(
                    strokeColor = MaterialTheme.colorScheme.onPrimary,
                    strokeSize = 8.dp,
                    progressAll = progress.value,
                    modifier = Modifier.size(300.dp)
                )
                if (progress.value >=99f)
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
@Preview(showBackground = true, device = Devices.TABLET)
fun LoginScreenPreview() {
    VisitComposeTheme {
        LoginScreen(
            {}
        )
    }

}