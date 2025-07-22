package org.sparktalk.project

import androidx.compose.ui.graphics.vector.ImageVector
import org.sparktalk.project.styles.icon.CustomIcons

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", CustomIcons.icHome)
    object Category : Screen("category", "Category", CustomIcons.icCategory)
    object Cart : Screen("cart", "Cart", CustomIcons.CartIcon)
    object Profile : Screen("profile", "Profile", CustomIcons.icProfile)
}