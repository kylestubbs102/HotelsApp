package com.example.hotelsapp.data.remote.dto.requests.listhotels


import com.example.hotelsapp.data.remote.dto.common.Sort
import com.example.hotelsapp.data.remote.dto.common.SortOrder
import com.google.gson.annotations.SerializedName

data class ListHotelsRequest(
    @SerializedName("geoId")
    val geoId: Int,
    @SerializedName("boundingBox")
    val boundingBox: BoundingBox? = null,
    @SerializedName("checkIn")
    val checkIn: String? = null,
    @SerializedName("checkOut")
    val checkOut: String? = null,
    @SerializedName("filters")
    val filters: List<Filter>? = null,
    @SerializedName("rooms")
    val rooms: List<Room>? = null,
    @SerializedName("sort")
    val sort: Sort? = null,
    @SerializedName("sortOrder")
    val sortOrder: SortOrder? = null,
    @SerializedName("updateToken")
    val updateToken: String? = null,
)