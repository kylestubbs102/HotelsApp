package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class Container(
    @SerializedName("datePicker")
    val datePicker: DatePicker,
    @SerializedName("navTitle")
    val navTitle: Any?,
    @SerializedName("pageBanners")
    val pageBanners: Any?,
    @SerializedName("plusMarketingBanner")
    val plusMarketingBanner: Any?,
    @SerializedName("route")
    val route: Route,
    @SerializedName("searchGhostText")
    val searchGhostText: SearchGhostText,
    @SerializedName("searchTitle")
    val searchTitle: Any?,
    @SerializedName("shoppingCart")
    val shoppingCart: Any?,
    @SerializedName("showMapToggle")
    val showMapToggle: Boolean,
    @SerializedName("__typename")
    val typename: String
)