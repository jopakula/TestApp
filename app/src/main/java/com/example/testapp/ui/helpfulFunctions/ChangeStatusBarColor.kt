package com.example.testapp.ui.helpfulFunctions

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun ChangeStatusBarColor(color: Color, isIconsLight: Boolean) {
    val view = LocalView.current
    SideEffect {
        val window = view.context.findActivity().window
        window.statusBarColor = color.toArgb()
        WindowCompat.getInsetsController(window, view)?.isAppearanceLightStatusBars = !isIconsLight
    }
}
