package org.sparktalk.project.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

actual object SystemUiController {
    actual fun setStatusBarColor(
        color: Color,
        darkIcons: Boolean
    ) {
    }

    @Composable
    actual fun ConfigureSystemBars(
        statusBarColor: Color,
        darkIcons: Boolean
    ) {
    }
}