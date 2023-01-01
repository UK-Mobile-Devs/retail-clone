package com.mobiledevs.retailclone.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mobiledevs.retailclone.feature.home.HomeScreen
import com.mobiledevs.retailclone.ui.components.BottomBar

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: String,
    scrollState: LazyListState
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }
        //another screen
    }
}

@Composable
fun SetupNavigation(startDestination: String) {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val scrollState = rememberLazyListState()
    val state by remember { derivedStateOf { scrollState.firstVisibleItemIndex == 0 } }

    Scaffold(
        bottomBar = {
            if ((currentRoute == Screen.Home.route && state)) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        BottomBar(navController = navController)
                    }
                }
            }
        },
        content = {
            NavigationGraph(
                navController = navController,
                scrollState = scrollState,
                startDestination = startDestination
            )
            it //unused
        }
    )
}
