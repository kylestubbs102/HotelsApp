package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class GettingThere(
    @SerializedName("sectionTitle")
    val sectionTitle: SectionTitleX,
    @SerializedName("transportItems")
    val transportItems: List<TransportItem>,
    @SerializedName("__typename")
    val typename: String
)