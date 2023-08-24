package com.example.hotelsapp.presentation.navigation

sealed class NavRoute(val path: String) {
    object Home : NavRoute(path = "home")
    object HotelDetail : NavRoute(path = "hoteldetail")
    object HotelMap : NavRoute(path = "map")
    object HotelsMap : NavRoute(path = "maps")
}
