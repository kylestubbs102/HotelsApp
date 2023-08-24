package com.example.hotelsapp.data.local.mapper

import com.example.hotelsapp.data.local.entity.HotelReviewEntity
import com.example.hotelsapp.data.remote.dto.responses.gethoteldetails.GetHotelDetailsResponse
import com.example.hotelsapp.domain.model.HotelReviewRow
import org.json.JSONObject

fun HotelReviewEntity.toHotelReviewRow(): HotelReviewRow {
    return HotelReviewRow(
        review = review,
        date = date,
        username = username,
        avatarUrlTemplate = avatarUrlTemplate,
    )
}

fun GetHotelDetailsResponse.toHotelReviewEntities(contentId: String): List<HotelReviewEntity> =
    this.data.appPresentationQueryAppDetailV2[0].sections.mapNotNull {
        it.mediumCardsCarouselContent?.map { carouselContent ->
            HotelReviewEntity(
                rid = getRid(carouselContent.trackingKey),
                contentId = contentId,
                review = carouselContent.cardTitle.string,
                date = carouselContent.primaryInfo.text,
                username = carouselContent.contributor.primaryInfo.string,
                avatarUrlTemplate = carouselContent.contributor.avatar.data.photoSizeDynamic.urlTemplate,
                lastModified = System.currentTimeMillis(),
            )
        }
    }.flatten()

private fun getRid(trackingKey: String?): String {
    val jsonObject = trackingKey?.let { JSONObject(it) }

    return jsonObject?.optInt(REVIEW_ID_KEY, -1).toString()
}

private const val REVIEW_ID_KEY = "rid"
