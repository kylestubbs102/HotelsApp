package com.example.hotelsapp.data.remote.dto.responses.listnearby


import com.google.gson.annotations.SerializedName

data class AppPresentationQueryNearToALocation(
    @SerializedName("commerce")
    val commerce: Commerce,
    @SerializedName("container")
    val container: Container,
    @SerializedName("datePickerConfig")
    val datePickerConfig: Any?,
    @SerializedName("filters")
    val filters: Filters,
    @SerializedName("impressions")
    val impressions: List<Impression>,
    @SerializedName("mapSections")
    val mapSections: List<MapSection>,
    @SerializedName("skippedSections")
    val skippedSections: List<Any>,
    @SerializedName("statusV2")
    val statusV2: StatusV2,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("updatedClusterIds")
    val updatedClusterIds: List<Any>
)