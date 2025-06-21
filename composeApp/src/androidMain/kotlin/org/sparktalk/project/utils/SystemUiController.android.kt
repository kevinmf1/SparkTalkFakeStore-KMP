package org.sparktalk.project.utils

import android.os.Build
import android.view.WindowInsets
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

actual object SystemUiController {
    actual fun setStatusBarColor(color: Color, darkIcons: Boolean) {
        // Implementation for Android
    }

    @Composable
    actual fun ConfigureSystemBars(
        statusBarColor: Color,
        darkIcons: Boolean
    ) {
        val view = LocalView.current
        val window = (view.context as android.app.Activity).window

        DisposableEffect(statusBarColor, darkIcons) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) { // Android 15+
                window.decorView.setOnApplyWindowInsetsListener { view, insets ->
                    val statusBarInsets = insets.getInsets(WindowInsets.Type.statusBars())
                    view.setBackgroundColor(statusBarColor.toArgb())

                    // Adjust padding to avoid overlap
                    view.setPadding(0, statusBarInsets.top, 0, 0)
                    insets
                }
            } else {
                // For Android 14 and below
                window.statusBarColor = statusBarColor.toArgb()
            }

            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars = darkIcons
            }
            onDispose {}
        }
    }
}