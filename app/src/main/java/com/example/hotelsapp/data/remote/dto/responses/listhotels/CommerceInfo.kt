package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class CommerceInfo(
    @SerializedName("commerceSummary")
    val commerceSummary: Any?,
    @SerializedName("commerceType")
    val commerceType: String,
    @SerializedName("cta")
    val cta: Cta?,
    @SerializedName("details")
    val details: Details?,
    @SerializedName("labels")
    val labels: List<Any>,
    @SerializedName("loadingMessage")
    val loadingMessage: LoadingMessage?,
    @SerializedName("priceForDisplay")
    val priceForDisplay: PriceForDisplay?,
    @SerializedName("pricingPeriod")
    val pricingPeriod: Any?,
    @SerializedName("provider")
    val provider: String,
    @SerializedName("roomUrgencyMessage")
    val roomUrgencyMessage: Any?,
    @SerializedName("strikethroughPrice")
    val strikethroughPrice: Any?,
    @SerializedName("__typename")
    val typename: String
)