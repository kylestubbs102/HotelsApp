package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class AppPresentationQueryAppDetailV2(
    @SerializedName("commerce")
    val commerce: Commerce,
    @SerializedName("container")
    val container: Container,
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