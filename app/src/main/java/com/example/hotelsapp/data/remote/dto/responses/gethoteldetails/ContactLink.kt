package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class ContactLink(
    @SerializedName("clickTrackingUrl")
    val clickTrackingUrl: Any?,
    @SerializedName("icon")
    val icon: Any?,
    @SerializedName("link")
    val link: Link,
    @SerializedName("linkType")
    val linkType: String,
    @SerializedName("__typename")
    val typename: String
)