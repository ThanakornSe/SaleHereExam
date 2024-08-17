package com.salehere.salehereexam.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.salehere.salehereexam.R

data class BottomNavigationItem(
    val icon : Int = 0,
    val route : String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                icon = R.drawable.ic_home,
                route = NavigationItem.Home.route
            ),
            BottomNavigationItem(
                icon = R.drawable.ic_wallet,
                route = NavigationItem.Wallet.route
            ),
            BottomNavigationItem(
                icon = R.drawable.ic_medal,
                route = NavigationItem.Achievement.route
            ),
            BottomNavigationItem(
                icon = R.drawable.ic_profile,
                route = NavigationItem.Profile.route
            ),
        )
    }
}