package com.salehere.salehereexam.ui.navigation

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.salehere.salehereexam.ui.home.compose.HomeMainScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationItem.Home.route,
    ) {
        composable(NavigationItem.Home.route) {
            HomeMainScreen(navHostController = navController)
        }
        composable(NavigationItem.Goal.route) {
            Surface {

            }
        }
        composable(NavigationItem.Wallet.route) {
            Surface {

            }
        }
        composable(NavigationItem.Achievement.route) {
            Surface {

            }
        }
        composable(NavigationItem.Profile.route) {
            Surface {

            }
        }
    }
}