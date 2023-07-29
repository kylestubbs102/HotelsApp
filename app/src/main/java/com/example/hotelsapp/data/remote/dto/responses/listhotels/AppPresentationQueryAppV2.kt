package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class AppPresentationQueryAppV2(
    @SerializedName("availableSorts")
    val availableSorts: List<AvailableSort>,
    @SerializedName("barItems")
    val barItems: List<BarItem>,
    @SerializedName("commerce")
    val commerce: Commerce,
    @SerializedName("container")
    val container: Container,
    @SerializedName("datePickerConfig")
    val datePickerConfig: DatePickerConfig,
    @SerializedName("filters")
    val filters: Filters,
    @SerializedName("impressions")
    val impressions: List<Impression>,
    @SerializedName("mapSections")
    val mapSections: List<MapSection>,
    @SerializedName("quickLinks")
    val quickLinks: Any?,
    @SerializedName("sections")
    val sections: List<Section>,
    @SerializedName("skippedSections")
    val skippedSections: List<String>,
    @SerializedName("statusV2")
    val statusV2: StatusV2,
    @SerializedName("trackingKey")
    val trackingKey: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("updatedClusterIds")
    val updatedClusterIds: Any?
)