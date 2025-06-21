package org.sparktalk.project

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.sparktalk.project.screen.CartScreen
import org.sparktalk.project.screen.CategoryScreen
import org.sparktalk.project.screen.HomeScreen
import org.sparktalk.project.screen.ProfileScreen
import org.sparktalk.project.utils.SystemUiController

@Composable
fun App() {

    MaterialTheme {
        SystemUiController.ConfigureSystemBars(Color.Gray, darkIcons = true)
        MainScreen()
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

    Scaffold(
        bottomBar = {
            NavigationBar {
                val currentRoute =
                    navController.currentBackStackEntryAsState().value?.destination?.route
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                screen.icon,
                                contentDescription = screen.label,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        label = { Text(screen.label) },
                        selected = currentRoute == screen.route,
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
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding),
            enterTransition = {
                EnterTransition.None
            },
            exitTransition = {
                ExitTransition.None
            }
        ) {
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Category.route) { CategoryScreen() }
            composable(Screen.Cart.route) { CartScreen() }
            composable(Screen.Profile.route) { ProfileScreen() }
        }
    }
}
