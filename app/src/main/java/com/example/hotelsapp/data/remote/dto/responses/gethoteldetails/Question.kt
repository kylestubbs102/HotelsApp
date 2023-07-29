package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("actions")
    val actions: Actions,
    @SerializedName("memberProfile")
    val memberProfile: MemberProfile,
    @SerializedName("text")
    val text: String,
    @SerializedName("thumbsUpAction")
    val thumbsUpAction: Any?,
    @SerializedName("thumbsUpCount")
    val thumbsUpCount: Any?,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("writtenDate")
    val writtenDate: WrittenDate
)