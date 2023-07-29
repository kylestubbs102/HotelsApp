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

interface HotelsCalls {

    suspend fun autoCompleteLocations(autoCompleteLocationsRequest: AutoCompleteLocationsRequest): AutoCompleteLocationsResponse

    suspend fun searchLocations(searchLocationsRequest: SearchLocationsRequest): SearchLocationsResponse

    suspend fun listNearbyLocations(listNearbyLocationsRequest: ListNearbyLocationsRequest): ListNearbyLocationsResponse

    suspend fun listHotelFilters(listHotelsFiltersRequest: ListHotelFiltersRequest): ListHotelFiltersResponse

    suspend fun listHotels(listHotelsRequest: ListHotelsRequest): ListHotelsResponse

    suspend fun getHotelDetails(getHotelDetailsRequest: GetHotelDetailsRequest): GetHotelDetailsResponse

    suspend fun getHotelOffers(getHotelOffersRequest: GetHotelOffersRequest): GetHotelOffersResponse
}
