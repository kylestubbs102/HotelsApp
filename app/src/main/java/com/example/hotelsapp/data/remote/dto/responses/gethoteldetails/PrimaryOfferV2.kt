package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class PrimaryOfferV2(
    @SerializedName("cta")
    val cta: Cta,
    @SerializedName("details")
    val details: List<Any>,
    @SerializedName("displayPrice")
    val displayPrice: Any?,
    @SerializedName("labels")
    val labels: List<Any>,
    @SerializedName("pricingPeriod")
    val pricingPeriod: Any?,
    @SerializedName("providerLogoUrl")
    val providerLogoUrl: String,
    @SerializedName("providerName")
    val providerName: String,
    @SerializedName("roomUrgencyMessage")
    val roomUrgencyMessage: Any?,
    @SerializedName("status")
    val status: String,
    @SerializedName("stickyFooter")
    val stickyFooter: StickyFooter,
    @SerializedName("strikeThroughPrice")
    val strikeThroughPrice: Any?,
    @SerializedName("__typename")
    val typename: String
)