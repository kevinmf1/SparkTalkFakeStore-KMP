package org.sparktalk.project

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.sparktalk.project.screen.CartScreen
import org.sparktalk.project.screen.CategoryScreen
import org.sparktalk.project.screen.HomeScreen
import org.sparktalk.project.screen.ProductDetail
import org.sparktalk.project.screen.ProfileScreen
import org.sparktalk.project.utils.SystemUiController

// feature bottom navigation Bar style
@Composable
fun App() {
    MaterialTheme {
        SystemUiController.ConfigureSystemBars(Color.Gray, darkIcons = true)
        MainScreen()
//        ProductDetail()
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(
        Screen.Home,
        Screen.Category,
        Screen.Cart,
        Screen.Profile
    )

    // Define custom colors to match the image
    val selectedBlue = Color(0xFF1E88E5)
    val unselectedGray = Color.Gray

    Scaffold(
        bottomBar = {
            NavigationBar(
                // Mengatur background NavigationBar menjadi putih
                containerColor = Color.White,
                // Menerapkan clip dan background untuk rounded top corners
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(Color.White)
            ) {
                val currentRoute =
                    navController.currentBackStackEntryAsState().value?.destination?.route
                items.forEach { screen ->
                    val isSelected = currentRoute == screen.route
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.label,
                                modifier = Modifier.size(22.dp),
                                tint = if (isSelected) selectedBlue else unselectedGray
                            )
                        },
                        label = {
                            Text(
                                text = screen.label,
                                fontSize = 12.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) selectedBlue else unselectedGray
                            )
                        },
                        selected = isSelected,
                        onClick = {
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding),
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Category.route) { CategoryScreen() }
            composable(Screen.Cart.route) { CartScreen() }
            composable(Screen.Profile.route) { ProfileScreen() }
        }
    }
}