package com.example.hotelsapp.data.remote.dto.responses.gethoteloffers


import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("background")
    val background: Any?,
    @SerializedName("clusterId")
    val clusterId: String?,
    @SerializedName("contentText")
    val contentText: ContentText?,
    @SerializedName("divider")
    val divider: Any?,
    @SerializedName("isComplete")
    val isComplete: Boolean?,
    @SerializedName("link")
    val link: Any?,
    @SerializedName("offersV2")
    val offersV2: List<OffersV2>?,
    @SerializedName("spacing")
    val spacing: String?,
    @SerializedName("stableDiffingType")
    val stableDiffingType: String,
    @SerializedName("trackingKey")
    val trackingKey: String?,
    @SerializedName("trackingTitle")
    val trackingTitle: String?,
    @SerializedName("__typename")
    val typename: String
)