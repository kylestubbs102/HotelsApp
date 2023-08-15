package com.example.hotelsapp.data.local.mapper

import com.example.hotelsapp.data.local.entity.HotelRowEntity
import com.example.hotelsapp.data.remote.dto.responses.listhotels.AppPresentationQueryAppV2
import com.example.hotelsapp.data.remote.dto.responses.listhotels.BubbleRating
import com.example.hotelsapp.data.remote.dto.responses.listhotels.GeoPoint
import com.example.hotelsapp.data.remote.dto.responses.listhotels.ListHotelsResponse
import com.example.hotelsapp.data.remote.dto.responses.listhotels.MapSection
import com.example.hotelsapp.domain.model.HotelRow
import org.json.JSONObject

fun List<HotelRowEntity>.toHotelRowList(): List<HotelRow> =
    this.map {
        HotelRow(
            hotel = it.hotel,
            contentId = it.contentId,
            latitude = it.latitude,
            longitude = it.longitude,
            updateToken = it.updateToken,
            rating = it.rating,
            numberOfReviews = it.numberOfReviews,
            photoUrl = it.photoUrl,
        )
    }

fun ListHotelsResponse.toHotelRowEntityList(geoId: Int): List<HotelRowEntity> {

    this.data.appPresentationQueryAppListV2[0].let {

        val titlesList = getTitlesList(it.mapSections)
        val contentIdList = getContentIdList(it.mapSections)
        val geoPointList = getCoordinatesList(it.mapSections)
        val ratingList = getRatingList(it.mapSections)
        val photoUrlList = getPhotoUrlList(it) ?: List(titlesList.size) { null }

        val hotelRowEntityList = mutableListOf<HotelRowEntity>()
        for (i in titlesList.indices) {
            hotelRowEntityList.add(
                HotelRowEntity(
                    contentId = contentIdList[i],
                    geoId = geoId,
                    hotel = titlesList[i],
                    longitude = geoPointList[i].longitude,
                    latitude = geoPointList[i].latitude,
                    updateToken = getUpdateToken(this),
                    rating = ratingList[i]?.rating,
                    numberOfReviews = ratingList[i]?.numberReviews?.string,
                    photoUrl = photoUrlList[i],
                    lastModified = System.currentTimeMillis(),
                )
            )
        }
        return hotelRowEntityList
    }
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
    var updateToken =
        listHotelsResponse.data.appPresentationQueryAppListV2[0].statusV2.pollingStatus?.updateToken

    if (updateToken == null) {
        val linkMap =
            listHotelsResponse.data.appPresentationQueryAppListV2[0].sections.last().link as Map<*, *>?
        if (linkMap?.containsKey("updateToken") == true) {
            updateToken = linkMap["updateToken"] as String
        }
    }

    return updateToken ?: ""
}

private const val GEO_ID_KEY = "lid"
