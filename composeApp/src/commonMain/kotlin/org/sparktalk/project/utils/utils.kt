package org.sparktalk.project.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

fun String.capitalizeFirstLetter(): String {
    return if (isNotEmpty()) {
        this[0].uppercaseChar() + substring(1)
    } else {
        this
    }
}

fun String.capitalizeEachFirstWord(): String {
    return split(" ").joinToString(" ") { it.capitalizeFirstLetter() }
}


@Composable
expect fun Modifier.conditionalSafeGesturesBottomPadding(): Modifier

fun parseColor(hex: String): Color {
    return Color(
        red = hex.substring(1, 3).toInt(16) / 255f,
        green = hex.substring(3, 5).toInt(16) / 255f,
        blue = hex.substring(5, 7).toInt(16) / 255f,
        alpha = 1f
    )
}

fun getCategoryBadgeStyle(category: String): Pair<Color, Color> {
    return when (category) {
        "men's clothing" -> Pair(parseColor("#DBEAFE"), parseColor("#1D4ED8"))
        "jewelery" -> Pair(parseColor("#FEF3C7"), parseColor("#D97706"))
        "electronics" -> Pair(parseColor("#DCFCE7"), parseColor("#16A34A"))
        "women's clothing" -> Pair(parseColor("#FCE7F3"), parseColor("#BE185D"))
        else -> Pair(parseColor("#F3F4F6"), parseColor("#374151"))
    }
}