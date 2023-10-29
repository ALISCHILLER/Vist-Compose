package com.msa.visitcompose.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.msa.visitcompose.ui.theme.BlueDark
import com.msa.visitcompose.ui.theme.Bluelight
import com.msa.visitcompose.ui.theme.Diamond
import com.msa.visitcompose.ui.theme.gradientColors
import kotlin.math.sin

@Composable
fun LinearGradient() {
    Canvas(modifier = canvasModifier2) {
        val middleW = size.width / 2
        //  val middleH = size.height / 2
        // drawLine(Color.Gray, Offset(0f, middleH), Offset(size.width - 1, middleH))
        // drawLine(Color.Gray, Offset(middleW, 0f), Offset(middleW, size.height - 1))
        val points1 = getSinusoidalPoints(size)

        drawPoints(
            brush = Brush.linearGradient(
                colors = listOf(BlueDark, Bluelight)
            ),
            points = points1,
            cap = StrokeCap.Round,
            pointMode = PointMode.Polygon,
            strokeWidth = 10f
        )

        val points2 = getSinusoidalPoints(size, 100f)
        drawPoints(
            brush = Brush.linearGradient(
                colors = listOf(BlueDark, Bluelight)
            ),
            points = points2,
            cap = StrokeCap.Round,
            pointMode = PointMode.Polygon,
            strokeWidth = 10f
        )

        val points3 = getSinusoidalPoints(size, 200f)
        drawPoints(
            brush = Brush.linearGradient(
                colors = listOf(Bluelight, BlueDark)
            ),

            points = points3,
            cap = StrokeCap.Round,
            pointMode = PointMode.Polygon,
            strokeWidth = 10f
        )
    }
}

fun getSinusoidalPoints(size: Size, horizontalOffset: Float = 0f): MutableList<Offset> {
    val points = mutableListOf<Offset>()
    val verticalCenter = size.height / 2

    for (x in 0 until size.width.toInt() step 20) {
        val y = (sin(x * (2f * Math.PI / size.width)) * verticalCenter + verticalCenter).toFloat()
        points.add(Offset(x.toFloat() + horizontalOffset, y))
    }
    return points
}
private val canvasModifier2 = Modifier
    .fillMaxWidth()
    .height(40.dp)




fun Modifier.drawAnimatedBorder(
    strokeWidth: Dp,
    shape: Shape,
    brush: (Size) -> Brush = {
        Brush.sweepGradient(gradientColors)
    },
    durationMillis: Int
) = composed {

    val infiniteTransition = rememberInfiniteTransition(label = "rotation")
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = "rotation"
    )

    Modifier
        .clip(shape)
        .drawWithCache {
            val strokeWidthPx = strokeWidth.toPx()

            val outline: Outline = shape.createOutline(size, layoutDirection, this)

            val pathBounds = outline.bounds

            onDrawWithContent {
                // This is actual content of the Composable that this modifier is assigned to
                drawContent()

                with(drawContext.canvas.nativeCanvas) {
                    val checkPoint = saveLayer(null, null)

                    // Destination

                    // We draw 2 times of the stroke with since we want actual size to be inside
                    // bounds while the outer stroke with is clipped with Modifier.clip

                    // 🔥 Using a maskPath with op(this, outline.path, PathOperation.Difference)
                    // And GenericShape can be used as Modifier.border does instead of clip
                    drawOutline(
                        outline = outline,
                        color = Color.Gray,
                        style = Stroke(strokeWidthPx * 2)
                    )

                    // Source
                    rotate(angle) {

                        drawCircle(
                            brush = brush(size),
                            radius = size.width,
                            blendMode = BlendMode.SrcIn,
                        )
                    }
                    restoreToCount(checkPoint)
                }
            }
        }
}
@Preview
@Composable
fun LinearGradientPreview() {
    LinearGradient()
}