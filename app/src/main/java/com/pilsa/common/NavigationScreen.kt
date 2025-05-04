package com.pilsa.common

import com.pilsa.R

sealed class NavigationScreen(val route: String, val icon: Int, val label: String) {
    data object Home : NavigationScreen("home", R.drawable.ico_nav_home, "Home")
    data object List : NavigationScreen("list", R.drawable.ico_nav_list, "List")
    data object MyPage : NavigationScreen("mypage", R.drawable.icon_nav_mypage, "MyPage")
    data object Calendar : NavigationScreen("calender", R.drawable.ico_nav_calender, "Calendar")
}
