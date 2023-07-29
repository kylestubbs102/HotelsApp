package com.example.hotelsapp.data.remote.dto.responses.gethoteloffers


import com.google.gson.annotations.SerializedName

data class AppPresentationQueryHotelCommerceV2(
    @SerializedName("impressions")
    val impressions: List<Impression>,
    @SerializedName("sections")
    val sections: List<Section>,
    @SerializedName("statusV2")
    val statusV2: StatusV2,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("updatedClusterIds")
    val updatedClusterIds: List<Any>
)