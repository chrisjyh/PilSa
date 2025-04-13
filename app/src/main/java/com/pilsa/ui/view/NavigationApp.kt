package com.pilsa.ui.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pilsa.common.NavigationScreen
import com.pilsa.ui.view.CalendarScreen.CalendarView
import com.pilsa.ui.view.MypageScreen.MyAppView
import com.pilsa.ui.view.homeScreen.HomeView
import com.pilsa.ui.view.listScreen.ListScreenView

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val items = listOf(
        NavigationScreen.Home,
        NavigationScreen.List,
        NavigationScreen.Calendar,
        NavigationScreen.Mypage
    )

    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(painterResource(id = screen.icon), contentDescription = screen.label) },
                label = { Text(screen.label) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
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

@Composable
fun BottomNavigationApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = NavigationScreen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(NavigationScreen.Home.route) { HomeView() }
            composable(NavigationScreen.List.route) { ListScreenView() }
            composable(NavigationScreen.Calendar.route) { CalendarView() }
            composable(NavigationScreen.Mypage.route) { MyAppView() }
        }
    }
}