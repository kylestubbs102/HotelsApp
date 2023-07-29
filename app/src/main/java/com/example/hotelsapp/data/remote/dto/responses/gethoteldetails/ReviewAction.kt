package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class ReviewAction(
    @SerializedName("actionName")
    val actionName: ActionName,
    @SerializedName("actionType")
    val actionType: String?,
    @SerializedName("authenticateUser")
    val authenticateUser: Boolean?,
    @SerializedName("link")
    val link: LinkX?,
    @SerializedName("poiName")
    val poiName: Any?,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("userDisplayName")
    val userDisplayName: String?,
    @SerializedName("userId")
    val userId: String?,
    @SerializedName("webUrl")
    val webUrl: WebUrlXX?
)