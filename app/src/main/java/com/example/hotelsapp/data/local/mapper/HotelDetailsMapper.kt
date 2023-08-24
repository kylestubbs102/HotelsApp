package com.example.hotelsapp.data.local.mapper

import com.example.hotelsapp.data.local.entity.HotelDetailsEntity
import com.example.hotelsapp.data.remote.dto.responses.gethoteldetails.GetHotelDetailsResponse
import com.example.hotelsapp.domain.model.HotelDetails

fun HotelDetailsEntity.toHotelDetails(): HotelDetails =
    HotelDetails(
        address = address ?: "Address unavailable",
        phoneNumber = phoneNumber ?: "Phone number unavailable",
        description = description ?: "Description unavailable"
    )

fun GetHotelDetailsResponse.toHotelDetailsEntity(contentId: String): HotelDetailsEntity =
    HotelDetailsEntity(
        contentId = contentId,
        address = getAddress(),
        phoneNumber = getPhoneNumber(),
        description = getDescription(),
        lastModified = System.currentTimeMillis(),
    )

private fun GetHotelDetailsResponse.getAddress(): String? =
    this.data.appPresentationQueryAppDetailV2[0].sections.mapNotNull {
        it.address?.address
    }.firstOrNull()

private fun GetHotelDetailsResponse.getPhoneNumber(): String? =
    this.data.appPresentationQueryAppDetailV2[0].sections.mapNotNull {
        it.contactLinks?.firstOrNull { contactLink ->
            contactLink.linkType == "PHONE"
        }?.link?.externalUrl
    }.firstOrNull()

private fun GetHotelDetailsResponse.getDescription(): String? =
    this.data.appPresentationQueryAppDetailV2[0].sections.mapNotNull {
        it.nullableContent?.get(0)?.text?.string
    }.firstOrNull()
