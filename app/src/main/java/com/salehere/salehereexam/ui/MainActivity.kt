package com.salehere.salehereexam.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.EnterTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.salehere.salehereexam.core.theme.AppTheme
import com.salehere.salehereexam.core.theme.borderBottomNavTint
import com.salehere.salehereexam.core.theme.bottomNavBarColor
import com.salehere.salehereexam.core.theme.disableIcon
import com.salehere.salehereexam.core.theme.dividerGrey
import com.salehere.salehereexam.core.theme.white
import com.salehere.salehereexam.ui.navigation.AppNavHost
import com.salehere.salehereexam.ui.navigation.BottomNavigationItem
import com.salehere.salehereexam.ui.navigation.Screen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val navController: NavHostController = rememberNavController()
                MainActivityScreen(navController = navController)
            }
        }
    }
}

@Composable
fun MainActivityScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            if (currentDestination?.route != Screen.GOAL.name) {
                NavigationBar(
                    containerColor = bottomNavBarColor,
                ) {
                    Column {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(dividerGrey)
                        )
                        Row {

                            BottomNavigationItem().bottomNavigationItems()
                                .forEach { navigationItem ->
                                    NavigationBarItem(
                                        selected = currentDestination?.hierarchy?.any { it.route == navigationItem.route } == true,
                                        label = null,
                                        colors = NavigationBarItemColors(
                                            selectedIconColor = borderBottomNavTint,
                                            selectedTextColor = borderBottomNavTint,
                                            selectedIndicatorColor = Color.Transparent,
                                            unselectedIconColor = disableIcon,
                                            unselectedTextColor = disableIcon,
                                            disabledIconColor = disableIcon,
                                            disabledTextColor = disableIcon
                                        ),
                                        icon = {
                                            Icon(
                                                modifier = Modifier.size(32.dp),
                                                painter = painterResource(id = navigationItem.icon),
                                                contentDescription = null
                                            )
                                        },
                                        onClick = {
                                            navController.navigate(navigationItem.route) {
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    )
                                }
                        }
                    }
                }
            }
        }
    ) { it
        AppNavHost(navController)
    }
}

@Composable
@Preview
private fun DefaultMainActivityScreenPreview() {
    MainActivityScreen(navController = rememberNavController())
}