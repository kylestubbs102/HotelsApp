package com.example.hotelsapp.data.remote.dto.responses.gethoteloffers


import com.google.gson.annotations.SerializedName

data class OffersV2(
    @SerializedName("commerceLink")
    val commerceLink: CommerceLink?,
    @SerializedName("details")
    val details: List<Detail>,
    @SerializedName("displayPrice")
    val displayPrice: DisplayPrice?,
    @SerializedName("labels")
    val labels: List<Label>,
    @SerializedName("providerLogoUrl")
    val providerLogoUrl: String?,
    @SerializedName("providerName")
    val providerName: String,
    @SerializedName("roomUrgencyMessage")
    val roomUrgencyMessage: Any?,
    @SerializedName("status")
    val status: String,
    @SerializedName("strikeThroughPrice")
    val strikeThroughPrice: StrikeThroughPrice?,
    @SerializedName("__typename")
    val typename: String
)