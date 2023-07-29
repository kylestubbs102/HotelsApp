package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class AppPresentationQueryAppSearch(
    @SerializedName("container")
    val container: Container,
    @SerializedName("sections")
    val sections: List<Section>,
    @SerializedName("statusV2")
    val statusV2: StatusV2,
    @SerializedName("trackingKey")
    val trackingKey: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("updatedClusterIds")
    val updatedClusterIds: List<Any>
)