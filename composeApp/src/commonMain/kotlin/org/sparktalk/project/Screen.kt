package org.sparktalk.project

import androidx.compose.ui.graphics.vector.ImageVector
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.ShoppingCart
import compose.icons.fontawesomeicons.solid.Th
import compose.icons.fontawesomeicons.solid.User

// Feature Bottom Nav Bar perubahan dari search ke Th


sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", FontAwesomeIcons.Solid.Home)
    object Category : Screen("category", "Category", FontAwesomeIcons.Solid.Th)
    object Cart : Screen("cart", "Cart", FontAwesomeIcons.Solid.ShoppingCart)
    object Profile : Screen("profile", "Profile", FontAwesomeIcons.Solid.User)
}