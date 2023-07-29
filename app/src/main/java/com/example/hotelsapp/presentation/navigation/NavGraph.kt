package com.example.hotelsapp.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hotelsapp.presentation.home.HomeScreen

@Composable
fun NavGraph(navController: NavHostController, padding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Home.path,
        modifier = Modifier.padding(paddingValues = padding)
    ) {
        composable(NavRoute.Home.path) {
            HomeScreen(navController)
        }
    }
}
