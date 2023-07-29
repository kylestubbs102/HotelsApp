package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("availableFilterGroups")
    val availableFilterGroups: List<AvailableFilterGroup>,
    @SerializedName("showAllText")
    val showAllText: ShowAllText,
    @SerializedName("__typename")
    val typename: String
)