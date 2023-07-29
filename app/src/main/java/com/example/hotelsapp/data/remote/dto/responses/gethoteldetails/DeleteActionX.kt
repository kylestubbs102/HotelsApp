package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class DeleteActionX(
    @SerializedName("authenticateUser")
    val authenticateUser: Boolean,
    @SerializedName("lcid")
    val lcid: Any?,
    @SerializedName("pid")
    val pid: Int,
    @SerializedName("pstid")
    val pstid: Int,
    @SerializedName("tpcid")
    val tpcid: Any?,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("webUrl")
    val webUrl: WebUrl
)