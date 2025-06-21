package org.sparktalk.project.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

expect object SystemUiController {
    fun setStatusBarColor(color: Color, darkIcons: Boolean = false)

    @Composable
    fun ConfigureSystemBars(statusBarColor: Color, darkIcons: Boolean = false)
}