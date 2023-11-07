package com.msa.visitcompose.ui.visit_navigator.bottomNav.utils

fun lerp(start: Float, stop: Float, fraction: Float) =
    (start * (1 - fraction) + stop * fraction)