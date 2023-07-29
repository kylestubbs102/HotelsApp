package com.example.hotelsapp.presentation.navigation

sealed class NavRoute(val path: String) {
    object Home : NavRoute(path = "home")
}