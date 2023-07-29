package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("badge")
    val badge: Badge?,
    @SerializedName("bubbleRating")
    val bubbleRating: BubbleRating?,
    @SerializedName("cardLink")
    val cardLink: CardLink,
    @SerializedName("cardPhoto")
    val cardPhoto: CardPhoto?,
    @SerializedName("cardTitle")
    val cardTitle: CardTitle,
    @SerializedName("closureInfo")
    val closureInfo: Any?,
    @SerializedName("commerceButtons")
    val commerceButtons: CommerceButtons?,
    @SerializedName("descriptiveText")
    val descriptiveText: Any?,
    @SerializedName("distance")
    val distance: Any?,
    @SerializedName("freeCancellationTooltip")
    val freeCancellationTooltip: Any?,
    @SerializedName("isSaved")
    val isSaved: Boolean,
    @SerializedName("labels")
    val labels: List<Any>,
    @SerializedName("merchandisingText")
    val merchandisingText: MerchandisingText?,
    @SerializedName("primaryInfo")
    val primaryInfo: PrimaryInfo?,
    @SerializedName("promotionalInfo")
    val promotionalInfo: Any?,
    @SerializedName("saveId")
    val saveId: SaveId,
    @SerializedName("secondaryInfo")
    val secondaryInfo: Any?,
    @SerializedName("stableDiffingType")
    val stableDiffingType: String,
    @SerializedName("trackingKey")
    val trackingKey: String,
    @SerializedName("trackingTitle")
    val trackingTitle: String,
    @SerializedName("__typename")
    val typename: String
)