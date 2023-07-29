package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class SingleButton(
    @SerializedName("commerceTrackingUrl")
    val commerceTrackingUrl: Any?,
    @SerializedName("link")
    val link: Link,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("variant")
    val variant: String
)