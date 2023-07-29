package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Container(
    @SerializedName("commerceDialog")
    val commerceDialog: Any?,
    @SerializedName("isSaved")
    val isSaved: Boolean,
    @SerializedName("navTitle")
    val navTitle: String,
    @SerializedName("pageBanners")
    val pageBanners: Any?,
    @SerializedName("saveId")
    val saveId: SaveId,
    @SerializedName("shareInfo")
    val shareInfo: ShareInfo,
    @SerializedName("shoppingCart")
    val shoppingCart: Any?,
    @SerializedName("__typename")
    val typename: String
)