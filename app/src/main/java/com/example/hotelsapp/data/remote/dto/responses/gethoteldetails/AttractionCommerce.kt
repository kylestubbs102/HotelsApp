package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class AttractionCommerce(
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("pax")
    val pax: List<Pax>,
    @SerializedName("setByUser")
    val setByUser: Boolean,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("updated")
    val updated: Any?
)