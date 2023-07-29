package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("allAnswerLink")
    val allAnswerLink: AllAnswerLink?,
    @SerializedName("allAnswerLinkV2")
    val allAnswerLinkV2: Any?,
    @SerializedName("answerActionText")
    val answerActionText: AnswerActionText?,
    @SerializedName("askAQuestionLink")
    val askAQuestionLink: AskAQuestionLink?,
    @SerializedName("bubbleRatingText")
    val bubbleRatingText: BubbleRatingText?,
    @SerializedName("cardLink")
    val cardLink: Any?,
    @SerializedName("disclaimer")
    val disclaimer: Disclaimer?,
    @SerializedName("filters")
    val filters: Filters?,
    @SerializedName("helpfulVote")
    val helpfulVote: HelpfulVote?,
    @SerializedName("htmlText")
    val htmlText: HtmlText?,
    @SerializedName("htmlTitle")
    val htmlTitle: HtmlTitle?,
    @SerializedName("initiallyCollapsed")
    val initiallyCollapsed: Boolean?,
    @SerializedName("labels")
    val labels: List<Any>?,
    @SerializedName("ownerResponse")
    val ownerResponse: Any?,
    @SerializedName("photoCTA")
    val photoCTA: PhotoCTAX?,
    @SerializedName("photos")
    val photos: List<Any>?,
    @SerializedName("poiName")
    val poiName: String?,
    @SerializedName("postingGuidelinesLink")
    val postingGuidelinesLink: PostingGuidelinesLink?,
    @SerializedName("publishedDate")
    val publishedDate: PublishedDate?,
    @SerializedName("question")
    val question: Question?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("ratingCountsV2")
    val ratingCountsV2: RatingCountsV2?,
    @SerializedName("ratingFilterId")
    val ratingFilterId: String?,
    @SerializedName("reviewActions")
    val reviewActions: List<ReviewAction>?,
    @SerializedName("reviewCTA")
    val reviewCTA: ReviewCTAX?,
    @SerializedName("reviewCountText")
    val reviewCountText: ReviewCountText?,
    @SerializedName("reviewRating")
    val reviewRating: Int?,
    @SerializedName("safetyText")
    val safetyText: Any?,
    @SerializedName("searchFilterId")
    val searchFilterId: String?,
    @SerializedName("stableDiffingType")
    val stableDiffingType: String?,
    @SerializedName("subRatings")
    val subRatings: SubRatings?,
    @SerializedName("submitAnswerAction")
    val submitAnswerAction: SubmitAnswerAction?,
    @SerializedName("submitQuestionAction")
    val submitQuestionAction: SubmitQuestionAction?,
    @SerializedName("subratings")
    val subratings: List<Subrating>?,
    @SerializedName("supplierName")
    val supplierName: Any?,
    @SerializedName("tip")
    val tip: Tip?,
    @SerializedName("tipText")
    val tipText: TipText?,
    @SerializedName("tooltip")
    val tooltip: Any?,
    @SerializedName("topAnswer")
    val topAnswer: TopAnswer?,
    @SerializedName("trackingKey")
    val trackingKey: String?,
    @SerializedName("trackingTitle")
    val trackingTitle: String?,
    @SerializedName("translatedByGoogle")
    val translatedByGoogle: Boolean?,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("userProfile")
    val userProfile: UserProfile?
)