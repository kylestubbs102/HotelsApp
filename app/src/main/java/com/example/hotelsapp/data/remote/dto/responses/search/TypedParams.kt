package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class TypedParams(
    @SerializedName("contentId")
    val contentId: String?,
    @SerializedName("contentType")
    val contentType: String,
    @SerializedName("geoId")
    val geoId: Int?,
    @SerializedName("isCollectionView")
    val isCollectionView: Any?,
    @SerializedName("isList")
    val isList: Any?,
    @SerializedName("isMap")
    val isMap: Any?,
    @SerializedName("isNearby")
    val isNearby: Any?,
    @SerializedName("nearLocationId")
    val nearLocationId: Any?,
    @SerializedName("nearLocationType")
    val nearLocationType: Any?,
    @SerializedName("pagee")
    val pagee: Any?,
    @SerializedName("routingFilters")
    val routingFilters: Any?,
    @SerializedName("sort")
    val sort: Any?,
    @SerializedName("sortOrder")
    val sortOrder: Any?,
    @SerializedName("spAttributionToken")
    val spAttributionToken: Any?,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("wasPlusShown")
    val wasPlusShown: Any?
)