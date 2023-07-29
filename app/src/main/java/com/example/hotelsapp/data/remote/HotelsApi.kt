package com.example.hotelsapp.data.remote

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
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface HotelsApi {

    @GET("locations/v2/auto-complete")
    suspend fun autoCompleteLocations(
        @QueryMap queryMap: Map<String, String>
    ): AutoCompleteLocationsResponse

    @POST("locations/v2/search")
    suspend fun searchLocations(
        @QueryMap queryMap: Map<String, String>,
        @Body body: SearchLocationsRequest
    ): SearchLocationsResponse

    @POST("locations/v2/list-nearby")
    suspend fun listNearbyLocations(
        @QueryMap queryMap: Map<String, String>,
        @Body body: ListNearbyLocationsRequest
    ): ListNearbyLocationsResponse

    @POST("hotel-filters/v2/list")
    suspend fun listHotelFilters(
        @QueryMap queryMap: Map<String, String>,
        @Body body: ListHotelFiltersRequest
    ): ListHotelFiltersResponse

    @POST("hotel/v2/list")
    suspend fun listHotels(
        @QueryMap queryMap: Map<String, String>,
        @Body body: ListHotelsRequest
    ): ListHotelsResponse

    @POST("hotel/v2/get-details")
    suspend fun getHotelDetails(
        @QueryMap queryMap: Map<String, String>,
        @Body body: GetHotelDetailsRequest
    ): GetHotelDetailsResponse

    @POST("hotel/v2/get-offers")
    suspend fun getHotelOffers(
        @QueryMap queryMap: Map<String, String>,
        @Body body: GetHotelOffersRequest
    ): GetHotelOffersResponse
}
