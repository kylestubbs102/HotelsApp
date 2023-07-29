package com.example.hotelsapp.data.remote.dto.responses.autocomplete


import com.google.gson.annotations.SerializedName

data class DetailsV2(
    @SerializedName("contact")
    val contact: Contact,
    @SerializedName("geocode")
    val geocode: Geocode,
    @SerializedName("isGeo")
    val isGeo: Boolean,
    @SerializedName("locationId")
    val locationId: Int,
    @SerializedName("names")
    val names: Names,
    @SerializedName("placeType")
    val placeType: String,
    @SerializedName("route")
    val route: Route?,
    @SerializedName("__typename")
    val typename: String
)