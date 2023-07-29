package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class TypedParams(
    @SerializedName("contentType")
    val contentType: String,
    @SerializedName("geoId")
    val geoId: Int,
    @SerializedName("isCollectionView")
    val isCollectionView: Any?,
    @SerializedName("isList")
    val isList: Boolean,
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
    val routingFilters: List<RoutingFilter>,
    @SerializedName("sort")
    val sort: String,
    @SerializedName("sortOrder")
    val sortOrder: String,
    @SerializedName("__typename")
    val typename: String
)