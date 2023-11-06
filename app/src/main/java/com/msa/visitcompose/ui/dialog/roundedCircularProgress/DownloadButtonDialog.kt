package com.msa.visitcompose.ui.dialog.roundedCircularProgress

import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.msa.visitcompose.ui.theme.Diamond
import com.msa.visitcompose.ui.theme.VisitComposeTheme

import kotlinx.coroutines.launch
import kotlin.math.roundToInt


@Composable
fun DownloadButtonDialog(
    strokeColor: Color,
    strokeSize: Dp,
    progressAll: Float,
    modifier: Modifier = Modifier,
) {

    var startDownload by remember {
        mutableStateOf(true)
    }

    
    Dialog(onDismissRequest = { /*TODO*/ }) {
       Card(
           modifier = Modifier
               .fillMaxWidth()
               .height(IntrinsicSize.Min)
               .padding(15.dp)
           ,
           elevation = CardDefaults.cardElevation(
               defaultElevation = 10.dp,
           ),
           colors = CardDefaults.cardColors(
               containerColor = MaterialTheme.colorScheme.primary
           ),
           border = BorderStroke(2.dp, Diamond),
           shape = RoundedCornerShape(16.dp),
       ) {
           Column (
               modifier=Modifier.padding(5.dp),
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally
           ){
               Text(
                   text = "دریافت اصلاعات",
                   color = Color.White,
                   fontFamily = FontFamily.Serif
               )
               Box(
                   contentAlignment = Alignment.Center,
                   modifier = Modifier
                       .fillMaxSize()
                       .padding(10.dp)
                       .background(MaterialTheme.colorScheme.primary)
               ) {
                   DownloadButton(
                       onClick = { startDownload = !startDownload },
                       strokeColor = MaterialTheme.colorScheme.onPrimary,
                       strokeSize = 8.dp,
                       progress = progressAll,
                       modifier = Modifier.size(300.dp)
                   )
               }
           }
       }

    }
    
}

@Preview
@Composable
fun DownloadButtonDialogPreview() {
    var startDownload by remember {
        mutableStateOf(true)
    }
    DownloadButtonDialog(
        strokeColor = MaterialTheme.colorScheme.onPrimary,
        strokeSize = 8.dp,
        progressAll = 10f,
        modifier = Modifier.size(300.dp),
    )
}

