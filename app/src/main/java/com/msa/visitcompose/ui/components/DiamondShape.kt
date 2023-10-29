package com.msa.visitcompose.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp


@Composable
fun DiamondShapeComponents() {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(DiamondShape)
                .background(Color.Red)
                .clip(RoundedCornerShape(14.dp))
        ) {

        }
    }

}

val DiamondShape: Shape = object : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path()
        val starPoints = 2
        val innerRadiusFactor = 0.8f
        val centerX = size.width / 2
        val centerY = size.height / 2
        val angleStep = 360f / (starPoints * 2)
        val corner=20f
        for (i in 0 until starPoints * 2) {
            val currentAngle = i * angleStep + 90f
            val radius = if (i % 2 == 0) {
                size.width / 2
            } else {
                size.width / 2 * innerRadiusFactor
            }

            val x = centerX + radius * kotlin.math.cos(Math.toRadians(currentAngle.toDouble()))
                .toFloat()
            val y = centerY + radius * kotlin.math.sin(Math.toRadians(currentAngle.toDouble()))
                .toFloat()

            if (i == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }
        }

        path.close()


        return Outline.Generic(path)
    }
}
@Preview(showBackground = true)
@Composable
fun DiamondShapeComponentsPreview() {
    DiamondShapeComponents()
}





@Preview
@Composable
fun test() {
    Canvas(modifier = Modifier.fillMaxWidth().aspectRatio(1f)) {
        val rect = Rect(Offset.Zero, size)
        val trianglePath = Path().apply {
            moveTo(rect.topCenter)

            lineTo(rect.centerRight)
            lineTo(rect.centerLeft)
            moveTo(rect.bottomCenter)
            close()
        }

        drawIntoCanvas { canvas ->
            canvas.drawOutline(
                outline = Outline.Generic(trianglePath),
                paint = Paint().apply {
                    color = Color.Black
                    pathEffect = PathEffect.cornerPathEffect(rect.maxDimension / 3)
                }
            )
        }
    }

    
}

fun Path.moveTo(offset: Offset) = moveTo(offset.x, offset.y)
fun Path.lineTo(offset: Offset) = lineTo(offset.x, offset.y)