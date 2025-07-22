package org.sparktalk.project

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.savedstate.read
import com.diamondedge.logging.logging
import kotlinx.serialization.json.Json
import org.sparktalk.project.data.network.Product
import org.sparktalk.project.screen.CartScreen
import org.sparktalk.project.screen.CategoryScreen
import org.sparktalk.project.screen.HomeScreen
import org.sparktalk.project.screen.ProductDetail
import org.sparktalk.project.screen.ProfileScreen
import org.sparktalk.project.styles.AppTextStyles
import org.sparktalk.project.utils.SystemUiController
import org.sparktalk.project.utils.base64Decode

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

    // Define custom colors to match the image
    val selectedBlue = Color(0xFF1E88E5)
    val unselectedGray = Color.Gray

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val showBottomBar = currentRoute in listOf(
        Screen.Home.route, Screen.Category.route, Screen.Cart.route, Screen.Profile.route
    )

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = Color.White,
                    modifier = Modifier
                        .background(Color.White)
                        .drawBehind {
                            val strokeWidth = 1.dp.toPx()
                            drawLine(
                                color = Color(0xFFE5E7EB),
                                start = androidx.compose.ui.geometry.Offset(0f, 0f),
                                end = androidx.compose.ui.geometry.Offset(size.width, 0f),
                                strokeWidth = strokeWidth
                            )
                        }
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
                                    style = if (isSelected) AppTextStyles.poppinsBold16()
                                        .copy(fontSize = 12.sp) else AppTextStyles.poppinsRegular16()
                                        .copy(fontSize = 12.sp),
                                    color = if (isSelected) selectedBlue else unselectedGray
                                )
                            },
                            selected = isSelected,
                            onClick = {
                                when (screen.route) {
                                    Screen.Home.route -> {
                                        if (currentRoute != Screen.Home.route) {
                                            navController.navigate(Screen.Home.route) {
                                                popUpTo(Screen.Home.route) { inclusive = true }
                                                launchSingleTop = true
                                            }
                                        }
                                    }

                                    Screen.Category.route -> {
                                        if (currentRoute != Screen.Category.route) {
                                            navController.navigate(Screen.Category.route) {
                                                popUpTo(Screen.Home.route)
                                                launchSingleTop = true
                                            }
                                        }
                                    }

                                    Screen.Cart.route -> {
                                        if (currentRoute != Screen.Cart.route) {
                                            navController.navigate(Screen.Cart.route) {
                                                popUpTo(Screen.Home.route)
                                                launchSingleTop = true
                                            }
                                        }
                                    }

                                    Screen.Profile.route -> {
                                        if (currentRoute != Screen.Profile.route) {
                                            navController.navigate(Screen.Profile.route) {
                                                popUpTo(Screen.Home.route)
                                                launchSingleTop = true
                                            }
                                        }
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
        }
    ) { innerPadding ->
        val navHostModifier = if (showBottomBar) Modifier.padding(innerPadding) else Modifier
        NavHost(
            navController,
            startDestination = Screen.Home.route,
            modifier = navHostModifier,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            composable(Screen.Home.route) { HomeScreen(navController) }
            composable(Screen.Category.route) { CategoryScreen() }
            composable(Screen.Cart.route) { CartScreen() }
            composable(Screen.Profile.route) { ProfileScreen() }
            composable(
                route = "productDetail/{productJson}",
                arguments = listOf(navArgument("productJson") { type = NavType.StringType })
            ) { backStackEntry ->
                val logger = logging("home")
                val encodedJson = backStackEntry.arguments?.read { getString("productJson") }
                logger.info { "data1: $encodedJson" }
                if (encodedJson != null) {
                    val decodedJson = base64Decode(encodedJson)
                    val product = Json.decodeFromString<Product>(decodedJson)
                    ProductDetail(
                        product = product,
                        onBack = { navController.popBackStack() },
                        navController = navController
                    )
                }
            }
        }
    }
}