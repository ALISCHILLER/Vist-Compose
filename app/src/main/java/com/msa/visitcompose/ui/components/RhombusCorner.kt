package com.msa.visitcompose.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.msa.visitcompose.ui.theme.QuickSilver
import com.msa.visitcompose.ui.theme.VisitComposeTheme
import com.msa.visitcompose.util.JlResDimens

@Composable
fun RhombusCorner(
    color: Color
) {
    var visible by remember {
        mutableStateOf(true)
    }
    val animatedAlpha by animateFloatAsState(
        targetValue = if (visible) 1.0f else 0f,
        label = "alpha"
    )
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .rotate(45f)
            .shadow(
                color = QuickSilver,
                offsetX = 0.3.dp,
                offsetY = 3.dp,
                spread = 3.dp,
                blurRadius = 24.0.dp
            )
            .graphicsLayer {
                alpha = animatedAlpha
            }
            .border(
                brush = Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                    )
                ),
                width = JlResDimens.dp1,
                shape = RoundedCornerShape(JlResDimens.dp10)
            )
            .clip(RoundedCornerShape(24.dp))
    ) {
        drawRect(color)
    }
}

@Preview(showBackground = true)
@Composable
fun rhombusCornerPreview() {
    VisitComposeTheme {
        RhombusCorner(Color.Blue)
    }

}


@Preview
@Composable
fun Card1() {





}


class DShop():Shape{
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    )= Outline.Generic(Path().apply {


    })

}