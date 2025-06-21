package org.sparktalk.project.utils
import android.content.res.Resources
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars

actual fun getStatusBarHeight(): Int {
//    val resources = AppContext.get().resources
//    val resourceId = WindowInsets.statusBars.getTop(resources)
//    return if (resourceId > 0) resources.getDimensionPixelSize(resourceId) else 0
    return 1
}