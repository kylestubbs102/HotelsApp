package com.example.hotelsapp.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hotelsapp.presentation.home.HomeScreen
import com.example.hotelsapp.presentation.hoteldetail.HotelDetailScreen

const val CONTENT_ID = "contentId"

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
        composable(NavRoute.HotelDetail.path + "/{$CONTENT_ID}") {
            HotelDetailScreen(navController)
        }
    }
}
