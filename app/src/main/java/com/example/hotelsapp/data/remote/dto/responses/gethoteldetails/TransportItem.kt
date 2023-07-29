package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class TransportItem(
    @SerializedName("transitAndTravel")
    val transitAndTravel: TransitAndTravel,
    @SerializedName("__typename")
    val typename: String
)