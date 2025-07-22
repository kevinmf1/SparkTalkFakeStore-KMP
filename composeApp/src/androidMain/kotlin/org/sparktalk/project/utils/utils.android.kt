package org.sparktalk.project.utils

import android.os.Build
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.Dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Composable
actual fun Modifier.conditionalSafeGesturesBottomPadding(): Modifier {
    if(Build.VERSION.SDK_INT < 34) {
        return this.then(Modifier.safeGesturesPadding())
    }

    val view = LocalView.current
    val bottomInsetPx = ViewCompat.getRootWindowInsets(view)
        ?.getInsets(WindowInsetsCompat.Type.systemGestures())
        ?.bottom ?: 0
    val bottomInsetDp: Dp = with(androidx.compose.ui.platform.LocalDensity.current) { bottomInsetPx.toDp() }
    return this.then(Modifier.padding(bottom = bottomInsetDp))
}