package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class AppSearchCardContent(
    @SerializedName("badge")
    val badge: Any?,
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
    val commerceButtons: Any?,
    @SerializedName("descriptiveText")
    val descriptiveText: DescriptiveText?,
    @SerializedName("distance")
    val distance: Any?,
    @SerializedName("isSaved")
    val isSaved: Boolean?,
    @SerializedName("labels")
    val labels: List<Label>,
    @SerializedName("primaryInfo")
    val primaryInfo: PrimaryInfo,
    @SerializedName("saveId")
    val saveId: SaveId?,
    @SerializedName("secondaryInfo")
    val secondaryInfo: SecondaryInfo?,
    @SerializedName("stableDiffingType")
    val stableDiffingType: String,
    @SerializedName("trackingKey")
    val trackingKey: String,
    @SerializedName("trackingTitle")
    val trackingTitle: String,
    @SerializedName("__typename")
    val typename: String
)