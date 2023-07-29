package com.example.hotelsapp.data.remote.dto.responses.autocomplete


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("buCategory")
    val buCategory: String?,
    @SerializedName("details")
    val details: Details?,
    @SerializedName("detailsV2")
    val detailsV2: DetailsV2?,
    @SerializedName("documentId")
    val documentId: String,
    @SerializedName("image")
    val image: Image?,
    @SerializedName("parentGeoDetails")
    val parentGeoDetails: ParentGeoDetails?,
    @SerializedName("route")
    val route: RouteX?,
    @SerializedName("scopeType")
    val scopeType: String?,
    @SerializedName("suggestionType")
    val suggestionType: String?,
    @SerializedName("text")
    val text: String?,
    @SerializedName("__typename")
    val typename: String
)