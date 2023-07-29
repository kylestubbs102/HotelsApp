package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class TopAnswer(
    @SerializedName("actions")
    val actions: ActionsX,
    @SerializedName("memberProfile")
    val memberProfile: MemberProfileX,
    @SerializedName("text")
    val text: String,
    @SerializedName("thumbsUpAction")
    val thumbsUpAction: ThumbsUpAction,
    @SerializedName("thumbsUpCount")
    val thumbsUpCount: Int,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("writtenDate")
    val writtenDate: WrittenDate
)