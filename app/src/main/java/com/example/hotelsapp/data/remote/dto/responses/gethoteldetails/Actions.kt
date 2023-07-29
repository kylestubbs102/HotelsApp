package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Actions(
    @SerializedName("deleteAction")
    val deleteAction: DeleteAction,
    @SerializedName("reportAction")
    val reportAction: ReportAction,
    @SerializedName("__typename")
    val typename: String
)