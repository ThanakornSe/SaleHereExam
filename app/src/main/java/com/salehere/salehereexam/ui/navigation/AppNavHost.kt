package com.salehere.salehereexam.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.salehere.salehereexam.core.theme.white
import com.salehere.salehereexam.ui.achievement.compose.AchievementMainScreen
import com.salehere.salehereexam.ui.goal.compose.GoalMainScreen
import com.salehere.salehereexam.ui.home.compose.HomeMainScreen
import com.salehere.salehereexam.ui.profile.compose.ProfileMainScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationItem.Home.route,
        enterTransition = {
            EnterTransition.None
        },
        exitTransition = {
            ExitTransition.None
        }
    ) {
        composable(NavigationItem.Home.route) {
            HomeMainScreen(navHostController = navController)
        }
        composable(NavigationItem.Goal.route) {
            GoalMainScreen()
        }
        composable(NavigationItem.Wallet.route) {
            Box(modifier = Modifier.fillMaxSize().statusBarsPadding().background(color = white))
        }
        composable(NavigationItem.Achievement.route) {
            AchievementMainScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileMainScreen()
        }
    }
}