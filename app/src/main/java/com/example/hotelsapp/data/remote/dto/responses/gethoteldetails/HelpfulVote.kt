package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class HelpfulVote(
    @SerializedName("hasVotedReviewHelpful")
    val hasVotedReviewHelpful: Boolean,
    @SerializedName("helpfulVoteAction")
    val helpfulVoteAction: HelpfulVoteAction,
    @SerializedName("helpfulVotes")
    val helpfulVotes: HelpfulVotes,
    @SerializedName("__typename")
    val typename: String
)