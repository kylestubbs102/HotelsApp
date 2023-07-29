package com.example.hotelsapp.data.remote.dto.responses.autocomplete


import com.google.gson.annotations.SerializedName

data class ParentGeoDetails(
    @SerializedName("names")
    val names: NamesX,
    @SerializedName("__typename")
    val typename: String
)