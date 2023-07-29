package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class TypedParamsXXX(
    @SerializedName("force")
    val force: Boolean?,
    @SerializedName("geoId")
    val geoId: Any?,
    @SerializedName("query")
    val query: String?,
    @SerializedName("referringViewUrl")
    val referringViewUrl: Any?,
    @SerializedName("routingFilters")
    val routingFilters: Any?,
    @SerializedName("__typename")
    val typename: String
)