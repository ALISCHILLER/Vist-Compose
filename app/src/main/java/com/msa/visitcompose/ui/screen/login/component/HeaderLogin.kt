package com.msa.visitcompose.ui.screen.login.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msa.visitcompose.R
import com.msa.visitcompose.ui.components.RhombusCorner
import com.msa.visitcompose.ui.components.blueBackground
import com.msa.visitcompose.ui.theme.BlueDark
import com.msa.visitcompose.ui.theme.VisitComposeTheme

@Composable
fun HeaderLogin() {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
        ,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "صفحه ورود",
                modifier = Modifier
                    .padding(5.dp)
                    .padding(top = 12.dp, start = 35.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = BlueDark
            )
            Text(
                text = "خوش آمدید",
                modifier = Modifier
                    .padding(5.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = BlueDark
            )
        }


        Box(
            modifier = Modifier
                .padding(5.dp)
                .padding(top = 12.dp),
            contentAlignment = Alignment.TopEnd

        ) {
            RhombusCorner(Color.White)
            Icon(
                painter = painterResource(id = R.drawable.presale),
                modifier = Modifier.size(100.dp),
                tint = Color.Blue,
                contentDescription = "presale"
            )
        }





    }

}

@Preview(showBackground = true)
@Composable
fun HeaderLoginPreview() {
    VisitComposeTheme {
        HeaderLogin()
    }

}