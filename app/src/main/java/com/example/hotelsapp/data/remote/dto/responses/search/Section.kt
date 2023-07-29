package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("appSearchCardContent")
    val appSearchCardContent: AppSearchCardContent?,
    @SerializedName("chipCardCarouselText")
    val chipCardCarouselText: Any?,
    @SerializedName("chipCardCarouselTitle")
    val chipCardCarouselTitle: Any?,
    @SerializedName("chipContent")
    val chipContent: List<ChipContent>?,
    @SerializedName("clusterId")
    val clusterId: String?,
    @SerializedName("icon")
    val icon: String?,
    @SerializedName("label")
    val label: Any?,
    @SerializedName("link")
    val link: Link?,
    @SerializedName("listTitle")
    val listTitle: ListTitle?,
    @SerializedName("seeAll")
    val seeAll: Any?,
    @SerializedName("stableDiffingType")
    val stableDiffingType: String,
    @SerializedName("subTitle")
    val subTitle: Any?,
    @SerializedName("tooltip")
    val tooltip: Any?,
    @SerializedName("trackingKey")
    val trackingKey: String,
    @SerializedName("trackingTitle")
    val trackingTitle: String,
    @SerializedName("__typename")
    val typename: String
)