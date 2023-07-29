package com.example.hotelsapp.data.remote.dto.requests.listnearby

import com.google.gson.annotations.SerializedName

data class ListNearbyLocationsRequest(
    @SerializedName("contentId")
    val contentId: String,
    @SerializedName("contentType")
    val contentType: ContentType,
    @SerializedName("boundingBox")
    val boundingBox: BoundingBox? = null,
    @SerializedName("filters")
    val filters: List<Filter>? = null,
)