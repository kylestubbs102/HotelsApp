package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("adSizes")
    val adSizes: List<String>?,
    @SerializedName("adUnitId")
    val adUnitId: String?,
    @SerializedName("background")
    val background: Any?,
    @SerializedName("clusterId")
    val clusterId: String?,
    @SerializedName("divider")
    val divider: String?,
    @SerializedName("groupName")
    val groupName: GroupName?,
    @SerializedName("link")
    val link: Any?,
    @SerializedName("listSingleCardContent")
    val listSingleCardContent: ListSingleCardContent?,
    @SerializedName("listSingleCardSectionTitle")
    val listSingleCardSectionTitle: Any?,
    @SerializedName("nullableText")
    val nullableText: NullableText?,
    @SerializedName("nullableTitle")
    val nullableTitle: NullableTitle?,
    @SerializedName("sectionType")
    val sectionType: String?,
    @SerializedName("spacing")
    val spacing: String?,
    @SerializedName("stableDiffingType")
    val stableDiffingType: String,
    @SerializedName("targetingParams")
    val targetingParams: List<TargetingParam>?,
    @SerializedName("tooltip")
    val tooltip: TooltipX?,
    @SerializedName("trackingKey")
    val trackingKey: String?,
    @SerializedName("trackingTitle")
    val trackingTitle: String?,
    @SerializedName("__typename")
    val typename: String
)