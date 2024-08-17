package com.salehere.salehereexam.ui.navigation

enum class Screen {
    HOME, GOAL, WALLET, ACHIEVEMENT, PROFILE
}

sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HOME.name)
    data object Goal : NavigationItem(Screen.GOAL.name)
    data object Wallet : NavigationItem(Screen.WALLET.name)
    data object Achievement : NavigationItem(Screen.ACHIEVEMENT.name)
    data object Profile : NavigationItem(Screen.PROFILE.name)
}
