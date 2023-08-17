package com.example.hotelsapp.data.local.mapper

import com.example.hotelsapp.data.local.entity.HotelPhotoEntity
import com.example.hotelsapp.data.remote.dto.responses.gethoteldetails.GetHotelDetailsResponse
import com.example.hotelsapp.domain.model.HotelPhoto

fun GetHotelDetailsResponse.toHotelPhotoEntities(contentId: String): List<HotelPhotoEntity> {
    return this.data.appPresentationQueryAppDetailV2[0].sections[0].heroContent?.map {
        HotelPhotoEntity(
            id = it.data.id,
            contentId = contentId,
            caption = it.data.caption,
            thumbsUpVotes = it.data.thumbsUpVotes,
            publishedDateTime = it.data.publishedDateTime,
            uploadDateTime = it.data.uploadDateTime,
            urlTemplate = it.data.photoSizeDynamic.urlTemplate,
            maxHeight = it.data.photoSizeDynamic.maxHeight,
            maxWidth = it.data.photoSizeDynamic.maxWidth,
            lastModified = System.currentTimeMillis(),
        )
    } ?: emptyList()
}

fun List<HotelPhotoEntity>.toHotelPhotoList(): List<HotelPhoto> = this.map {
    HotelPhoto(
        caption = it.caption,
        thumbsUpVotes = it.thumbsUpVotes,
        publishedDateTime = it.publishedDateTime,
        uploadDateTime = it.uploadDateTime,
        urlTemplate = it.urlTemplate,
        maxHeight = it.maxHeight,
        maxWidth = it.maxWidth,
    )
}