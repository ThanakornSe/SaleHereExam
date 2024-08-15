package com.salehere.salehereexam.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val icon : ImageVector = Icons.Filled.Home,
    val route : String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                icon = Icons.Filled.Home,
                route = NavigationItem.Home.route
            ),
            BottomNavigationItem(
                icon = Icons.Filled.Email,
                route = NavigationItem.Wallet.route
            ),
            BottomNavigationItem(
                icon = Icons.Filled.Star,
                route = NavigationItem.Achievement.route
            ),
            BottomNavigationItem(
                icon = Icons.Filled.Person,
                route = NavigationItem.Profile.route
            ),
        )
    }
}