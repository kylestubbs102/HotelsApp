package com.example.hotelsapp.data.remote.dto.responses.listhotelfilters


import com.google.gson.annotations.SerializedName

data class AppPresentationQueryAppV2(
    @SerializedName("availableSorts")
    val availableSorts: List<AvailableSort>,
    @SerializedName("filters")
    val filters: Filters,
    @SerializedName("impressions")
    val impressions: List<Impression>,
    @SerializedName("statusV2")
    val statusV2: StatusV2,
    @SerializedName("__typename")
    val typename: String
)