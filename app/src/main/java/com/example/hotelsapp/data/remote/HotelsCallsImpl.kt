package com.example.hotelsapp.data.remote

import com.example.hotelsapp.data.remote.dto.requests.autocomplete.AutoCompleteLocationsRequest
import com.example.hotelsapp.data.remote.dto.requests.gethoteldetails.GetHotelDetailsRequest
import com.example.hotelsapp.data.remote.dto.requests.gethoteloffers.GetHotelOffersRequest
import com.example.hotelsapp.data.remote.dto.requests.listhotelfilters.ListHotelFiltersRequest
import com.example.hotelsapp.data.remote.dto.requests.listhotels.ListHotelsRequest
import com.example.hotelsapp.data.remote.dto.requests.listnearby.ListNearbyLocationsRequest
import com.example.hotelsapp.data.remote.dto.requests.search.SearchLocationsRequest
import com.example.hotelsapp.data.remote.dto.responses.autocomplete.AutoCompleteLocationsResponse
import com.example.hotelsapp.data.remote.dto.responses.gethoteldetails.GetHotelDetailsResponse
import com.example.hotelsapp.data.remote.dto.responses.gethoteloffers.GetHotelOffersResponse
import com.example.hotelsapp.data.remote.dto.responses.listhotelfilters.ListHotelFiltersResponse
import com.example.hotelsapp.data.remote.dto.responses.listhotels.ListHotelsResponse
import com.example.hotelsapp.data.remote.dto.responses.listnearby.ListNearbyLocationsResponse
import com.example.hotelsapp.data.remote.dto.responses.search.SearchLocationsResponse
import com.example.hotelsapp.util.LocaleUtil
import com.example.hotelsapp.util.MapUtil.filterOutNullValues
import javax.inject.Inject

class HotelsCallsImpl @Inject constructor(
    private val hotelsApi: HotelsApi
) : HotelsCalls {

    override suspend fun autoCompleteLocations(autoCompleteLocationsRequest: AutoCompleteLocationsRequest): AutoCompleteLocationsResponse {
        val queryMap = getQueryMap(false, mapOf("query" to autoCompleteLocationsRequest.query))

        return hotelsApi.autoCompleteLocations(queryMap)
    }

    override suspend fun searchLocations(searchLocationsRequest: SearchLocationsRequest): SearchLocationsResponse {
        val queryMap = getQueryMap(presetMap = mapOf("query" to searchLocationsRequest.query))

        return hotelsApi.searchLocations(queryMap, searchLocationsRequest)
    }

    override suspend fun listNearbyLocations(listNearbyLocationsRequest: ListNearbyLocationsRequest): ListNearbyLocationsResponse {
        val queryMap = getQueryMap()

        return hotelsApi.listNearbyLocations(queryMap, listNearbyLocationsRequest)
    }

    override suspend fun listHotelFilters(listHotelsFiltersRequest: ListHotelFiltersRequest): ListHotelFiltersResponse {
        val queryMap = getQueryMap()

        return hotelsApi.listHotelFilters(queryMap, listHotelsFiltersRequest)
    }

    override suspend fun listHotels(listHotelsRequest: ListHotelsRequest): ListHotelsResponse {
        val queryMap = getQueryMap()

        return hotelsApi.listHotels(queryMap, listHotelsRequest)
    }

    override suspend fun getHotelDetails(getHotelDetailsRequest: GetHotelDetailsRequest): GetHotelDetailsResponse {
        val queryMap = getQueryMap()

        return hotelsApi.getHotelDetails(queryMap, getHotelDetailsRequest)
    }

    override suspend fun getHotelOffers(getHotelOffersRequest: GetHotelOffersRequest): GetHotelOffersResponse {
        val queryMap = getQueryMap()

        return hotelsApi.getHotelOffers(queryMap, getHotelOffersRequest)
    }

    /**
     * Add other values if specified. Also, include currency value if specified
     */
    private fun getQueryMap(
        includeCurrency: Boolean = true,
        presetMap: Map<String, String> = emptyMap()
    ): Map<String, String> {
        val map: MutableMap<String, String?> = mutableMapOf(
            "lang" to LocaleUtil.getLang(),
            "units" to LocaleUtil.getUnits(),
        )

        map.putAll(presetMap)

        // Add currency if specified
        if (includeCurrency) map["currency"] = LocaleUtil.getCurrency()

        return map.filterOutNullValues()
    }
}
