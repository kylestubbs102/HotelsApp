package com.example.hotelsapp.data.local.mapper

import android.util.Log
import com.example.hotelsapp.data.local.entity.HotelListEntity
import com.example.hotelsapp.data.remote.dto.responses.listhotels.AppPresentationQueryAppV2
import com.example.hotelsapp.data.remote.dto.responses.listhotels.BubbleRating
import com.example.hotelsapp.data.remote.dto.responses.listhotels.GeoPoint
import com.example.hotelsapp.data.remote.dto.responses.listhotels.ListHotelsResponse
import com.example.hotelsapp.data.remote.dto.responses.listhotels.MapSection
import com.example.hotelsapp.domain.model.HotelList
import com.example.hotelsapp.domain.model.HotelListRow
import org.json.JSONObject

fun HotelListEntity.toHotelList(): HotelList =
    HotelList(
        hotelRows = hotelRowsList,
        updateToken = updateToken,
    )

fun ListHotelsResponse.toHotelListEntity(geoId: Int): HotelListEntity {

    val hotelRowsList = this.data.appPresentationQueryAppListV2[0].let {

        val titlesList = getTitlesList(it.mapSections)
        val contentIdList = getContentIdList(it.mapSections)
        val geoPointList = getCoordinatesList(it.mapSections)
        val ratingList = getRatingList(it.mapSections)
        val photoUrlList = getPhotoUrlList(it) ?: List(titlesList.size) { null }

        val list = mutableListOf<HotelListRow>()
        for (i in titlesList.indices) {
            list.add(
                HotelListRow(
                    hotel = titlesList[i],
                    contentId = contentIdList[i],
                    longitude = geoPointList[i].longitude,
                    latitude = geoPointList[i].latitude,
                    rating = ratingList[i]?.rating,
                    numberOfReviews = ratingList[i]?.numberReviews?.string,
                    photoUrl = photoUrlList[i],
                )
            )
        }
        return@let list.filter { row -> row.isValid() }
    }

    return HotelListEntity(
        geoId = geoId,
        hotelRowsList = hotelRowsList,
        updateToken = getUpdateToken(this)
    )
}

private fun getTitlesList(mapSections: List<MapSection>): List<String> =
    mapSections.mapNotNull { mapSection ->
        mapSection.content?.map { it.cardTitle.string }
    }.flatten()

private fun getContentIdList(mapSections: List<MapSection>): List<Int> =
    mapSections.mapNotNull { mapSection ->
        mapSection.pins?.map {
            val jsonObject = JSONObject(it.trackingKey)
            jsonObject.optInt(GEO_ID_KEY, -1)
        }
    }.flatten()

private fun getCoordinatesList(mapSections: List<MapSection>): List<GeoPoint> =
    mapSections.mapNotNull { mapSection ->
        mapSection.pins?.map { it.geoPoint }
    }.flatten()

private fun getRatingList(mapSections: List<MapSection>): List<BubbleRating?> =
    mapSections.mapNotNull { mapSection ->
        mapSection.content?.map { it.bubbleRating }
    }.flatten()

private fun getPhotoUrlList(appPresentationQueryAppV2: AppPresentationQueryAppV2): List<String?>? {
    appPresentationQueryAppV2.mapSections.forEach { mapSection ->
        val urlList = mapSection.content?.map {
            it.cardPhoto?.sizes?.urlTemplate

            // TODO : Get url from listSingleCardContent.cardPhotos if the main one is null
        }
        // Return list if not null
        if (urlList != null) {
            return urlList
        }
    }
    // If mapSections were null, then return null
    return null
}

private fun getUpdateToken(listHotelsResponse: ListHotelsResponse): String {
    var updateToken = listHotelsResponse.data.appPresentationQueryAppListV2[0].statusV2.pollingStatus?.updateToken

    if (updateToken == null) {
        val linkMap = listHotelsResponse.data.appPresentationQueryAppListV2[0].sections.last().link as Map<*, *>?
        if (linkMap?.containsKey("updateToken") == true) {
            updateToken = linkMap["updateToken"] as String
        }
    }

    return updateToken ?: ""
}

private const val GEO_ID_KEY = "lid"
