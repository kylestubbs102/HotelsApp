package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class ListSingleCardContent(
    @SerializedName("badge")
    val badge: Badge?,
    @SerializedName("bubbleRating")
    val bubbleRating: BubbleRatingX?,
    @SerializedName("cardLink")
    val cardLink: CardLinkX,
    @SerializedName("cardPhotos")
    val cardPhotos: List<CardPhotoX>,
    @SerializedName("cardTitle")
    val cardTitle: CardTitle,
    @SerializedName("closureInfo")
    val closureInfo: Any?,
    @SerializedName("commerceButtons")
    val commerceButtons: CommerceButtonsX?,
    @SerializedName("commerceInfo")
    val commerceInfo: CommerceInfo?,
    @SerializedName("descriptiveText")
    val descriptiveText: Any?,
    @SerializedName("distance")
    val distance: Any?,
    @SerializedName("isSaved")
    val isSaved: Boolean,
    @SerializedName("labels")
    val labels: List<Any>,
    @SerializedName("primaryInfo")
    val primaryInfo: PrimaryInfo?,
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