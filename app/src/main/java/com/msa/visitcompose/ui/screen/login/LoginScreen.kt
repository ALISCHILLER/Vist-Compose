@file:OptIn(ExperimentalMaterial3Api::class)

package com.msa.visitcompose.ui.screen.login



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msa.visitcompose.ui.components.LinearGradient
import com.msa.visitcompose.ui.screen.login.component.FooterLogin
import com.msa.visitcompose.ui.screen.login.component.HeaderLogin
import com.msa.visitcompose.ui.screen.login.component.LoginSection
import com.msa.visitcompose.ui.theme.*
import com.msa.visitcompose.ui.theme.VisitComposeTheme


@Composable
fun LoginScreen() {
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
            LoginSection(modifier = Modifier.align(CenterHorizontally))
        }
        FooterLogin()
    }
}


@Composable
@Preview(showBackground = true)
@Preview(showBackground = true)
fun LoginScreenPreview() {
    VisitComposeTheme {
        LoginScreen()
    }

}