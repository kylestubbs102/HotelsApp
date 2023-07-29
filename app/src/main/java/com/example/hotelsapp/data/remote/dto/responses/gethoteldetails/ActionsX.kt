package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class ActionsX(
    @SerializedName("deleteAction")
    val deleteAction: DeleteActionX,
    @SerializedName("reportAction")
    val reportAction: ReportAction,
    @SerializedName("__typename")
    val typename: String
)