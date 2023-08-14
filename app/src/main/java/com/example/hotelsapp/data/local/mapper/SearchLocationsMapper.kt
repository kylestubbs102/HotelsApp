package com.example.hotelsapp.data.local.mapper

import com.example.hotelsapp.data.local.entity.LocationQueryEntity
import com.example.hotelsapp.data.remote.dto.responses.search.SearchLocationsResponse
import com.example.hotelsapp.data.remote.dto.responses.search.Section
import com.example.hotelsapp.domain.model.LocationQueryRow
import org.json.JSONObject

fun SearchLocationsResponse.toLocationQueryEntity(query: String): LocationQueryEntity {
    val hotelQueryRows = this.data.appPresentationQueryAppSearch.sections.map {
        LocationQueryRow(
            location = it.appSearchCardContent?.cardTitle?.string ?: "",
            city = getCity(it) ?: "",
            geoId = getGeoId(it) ?: -1
        )
    }.filter { it.isValid() }

    return LocationQueryEntity(
        query = query,
        hotelQueryList = hotelQueryRows
    )
}

private fun getCity(section: Section): String? =
    section.appSearchCardContent?.let {
        // In the case primaryInfo doesn't have the city, secondaryInfo will always have it. Check
        // secondaryInfo first and then primaryInfo if it's null
        it.secondaryInfo?.text ?: it.primaryInfo?.text
    }

private fun getGeoId(section: Section): Int? {
    // trackingKey is a jsonString that contains the geoId, whereas the contentId or geoId shows
    // up in the trackingTitle
    val jsonObject = section.appSearchCardContent?.trackingKey?.let { JSONObject(it) }

    return jsonObject?.optInt(GEO_ID_KEY, -1)
}

private const val GEO_ID_KEY = "lid"
