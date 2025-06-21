package org.sparktalk.project

import androidx.compose.ui.graphics.vector.ImageVector
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.CartPlus
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.Search
import compose.icons.fontawesomeicons.solid.User

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", FontAwesomeIcons.Solid.Home)
    object Category : Screen("category", "Category", FontAwesomeIcons.Solid.Search)
    object Cart : Screen("cart", "cart", FontAwesomeIcons.Solid.CartPlus)
    object Profile : Screen("profile", "Profile", FontAwesomeIcons.Solid.User)
}