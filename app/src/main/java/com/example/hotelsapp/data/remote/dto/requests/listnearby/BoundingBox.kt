package com.example.hotelsapp.data.remote.dto.requests.listnearby


import com.google.gson.annotations.SerializedName

data class BoundingBox(
    @SerializedName("northEastCorner")
    val northEastCorner: NorthEastCorner,
    @SerializedName("southWestCorner")
    val southWestCorner: SouthWestCorner
)