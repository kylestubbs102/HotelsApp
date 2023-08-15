package com.example.hotelsapp.data.repository

import com.example.hotelsapp.data.local.HotelsDao
import com.example.hotelsapp.data.local.mapper.toHotelRowEntityList
import com.example.hotelsapp.data.local.mapper.toHotelRowList
import com.example.hotelsapp.data.local.mapper.toLocationQueryEntityList
import com.example.hotelsapp.data.local.mapper.toLocationQueryRowList
import com.example.hotelsapp.data.remote.HotelsCalls
import com.example.hotelsapp.data.remote.dto.requests.listhotels.ListHotelsRequest
import com.example.hotelsapp.data.remote.dto.requests.search.SearchLocationsRequest
import com.example.hotelsapp.domain.model.HotelRow
import com.example.hotelsapp.domain.model.LocationQueryRow
import com.example.hotelsapp.domain.repository.HotelsRepository
import com.example.hotelsapp.util.Resource
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class HotelsRepositoryImpl(
    private val dao: HotelsDao,
    private val apiCalls: HotelsCalls
) : HotelsRepository {

    override suspend fun searchHotels(query: String): Flow<Resource<List<LocationQueryRow>>> =
        flow {
            emit(Resource.Loading())
            // query db and check if present
            if (dao.doesQueryExist(query)) {
                emit(Resource.Success(dao.getLocationQueryList(query).toLocationQueryRowList()))
                return@flow
            }

            // Fetch from server
            val searchLocationsRequest = SearchLocationsRequest(query)
            try {
                val searchLocationsResponse = apiCalls.searchLocations(searchLocationsRequest)

                // Map to db entity
                val entityList = searchLocationsResponse.toLocationQueryEntityList(query)

                // put and return from db
                dao.insertLocationQueryList(entityList)
                emit(Resource.Success(dao.getLocationQueryList(query).toLocationQueryRowList()))
            } catch (e: HttpException) {
                emit(Resource.Error("Failed due to HttpException: ${e.message}"))
            } catch (e: IOException) {
                emit(Resource.Error("Failed due to IOException: ${e.message}"))
            }
        }

    override suspend fun getHotelsList(
        geoId: Int,
        updateToken: String,
        isInitialFetch: Boolean
    ): Flow<Resource<List<HotelRow>>> =
        flow {
            emit(Resource.Loading())
            // If initial fetch, check if data is present and return if present.
            if (isInitialFetch && dao.doesHotelsListExist(geoId)) {
                emit(Resource.Success(dao.getHotelRowList(geoId).toHotelRowList()))
                return@flow
            }

            // Fetch from server
            val listHotelsRequest = ListHotelsRequest(geoId)
            try {
                val listHotelsResponse = apiCalls.listHotels(listHotelsRequest)

                // Map to db entity
                val entity = listHotelsResponse.toHotelRowEntityList(geoId)
                val newUpdateToken = entity.first().updateToken

                // put and return from db
                dao.insertHotelRowList(entity)
                emit(Resource.Success(dao.getHotelRowList(geoId, newUpdateToken).toHotelRowList()))
            } catch (e: HttpException) {
                emit(Resource.Error("Failed due to HttpException: ${e.message}"))
            } catch (e: IOException) {
                emit(Resource.Error("Failed due to IOException: ${e.message}"))
            } catch (e: NoSuchElementException) {
                emit(Resource.Error("Failed due to NoSuchElementException ${e.message}"))
            }
        }
}
