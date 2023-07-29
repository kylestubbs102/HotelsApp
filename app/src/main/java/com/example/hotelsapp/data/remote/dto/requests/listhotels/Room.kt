package com.example.hotelsapp.data.remote.dto.requests.listhotels


import com.google.gson.annotations.SerializedName

data class Room(
    @SerializedName("adults")
    val adults: Int,
    @SerializedName("childrenAges")
    val childrenAges: List<Int>
)