package com.msa.visitcompose.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)

val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val QuickSilver = Color(0xFF5E5E5E)
val Diamond = Color(0xFFE4E4E4)
val BlueDark = Color(0xFF14008A)
val Bluelight = Color(0xFF19A3EE)


val Lilac = Color(0xFFCCB6DC)
val Yellow = Color(0xFFFFCB66)
val YellowVariant = Color(0xFFFFDE9F)
val Coral = Color(0xFFF3A397)
val White = Color(0xFFFFFFFF)
val MintGreen = Color(0xFFACD6B8)
val DarkGray = Color(0xFF2B2B2D)

val DarkCoral = Color(0xFFF7A374)
val DarkYellow = Color(0xFFFFCE6F)
val Yellow_Awake = Color(0xFFffeac1)
val Yellow_Rem = Color(0xFFffdd9a)
val Yellow_Light = Color(0xFFffcb66)
val Yellow_Deep = Color(0xFFff973c)
val Green200 = Color(0xFFAEFF82)
val Green300 = Color(0xFFC9FCAD)
val Green500 = Color(0xFF07A312)

val DarkColor = Color(0xFF101522)
val DarkColor2 = Color(0xFF202532)
val LightColor = Color(0xFF414D66)
val LightColor2 = Color(0xFF626F88)


val gradientColors = listOf(
    Color.Red,
    Color.Magenta,
    Color.Blue,
    Color.Cyan,
    Color.Green,
    Color.Yellow,
    Color.Red
)
val GreenGradient = Brush.linearGradient(
    colors = listOf(Green300, Green200),
    start = Offset(0f, 0f),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)

val DarkGradient = Brush.verticalGradient(
    colors = listOf(DarkColor2, DarkColor)
)