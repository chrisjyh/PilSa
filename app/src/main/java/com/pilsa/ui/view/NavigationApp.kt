package com.pilsa.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pilsa.common.NavigationScreen
import com.pilsa.ui.theme.color.ColorSet
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
        NavigationScreen.MyPage
    )

    NavigationBar (
        containerColor = ColorSet.Main.LightColors.background,
        tonalElevation = 0.dp
    ) {
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
                },
                colors = NavigationBarItemColors(
                    selectedIndicatorColor = Color.Transparent,
                    selectedIconColor = ColorSet.Main.LightColors.primary,
                    selectedTextColor = ColorSet.Main.LightColors.primary,
                    unselectedIconColor = ColorSet.Main.LightColors.onSecondary,
                    unselectedTextColor = ColorSet.Main.LightColors.onSecondary,
                    disabledIconColor = Color.Transparent,
                    disabledTextColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
fun BottomNavigationApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            Column {
                BottomNavigationBar(navController)
                AdArea()
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = NavigationScreen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(NavigationScreen.Home.route) { HomeView() }
            composable(NavigationScreen.List.route) { ListScreenView() }
            composable(NavigationScreen.Calendar.route) { CalendarView() }
            composable(NavigationScreen.MyPage.route) { MyAppView() }
        }
    }
}

@Composable
fun LogoArea(
    content: @Composable () -> Unit
) {
    Column(
        Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Logo")
        }
        content()
    }
}

@Composable
fun AdArea(){
    Row (
       modifier = Modifier.fillMaxWidth().height(50.dp)
    ) {}
}