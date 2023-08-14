package com.example.hotelsapp.data.repository

import com.example.hotelsapp.data.local.HotelsDao
import com.example.hotelsapp.data.local.mapper.toHotelList
import com.example.hotelsapp.data.local.mapper.toHotelListEntity
import com.example.hotelsapp.data.local.mapper.toLocationQueryEntity
import com.example.hotelsapp.data.remote.HotelsCalls
import com.example.hotelsapp.data.remote.dto.requests.listhotels.ListHotelsRequest
import com.example.hotelsapp.data.remote.dto.requests.search.SearchLocationsRequest
import com.example.hotelsapp.domain.model.HotelList
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
                emit(Resource.Success(dao.getLocationQuery(query).hotelQueryList))
            }

            // Fetch from server
            val searchLocationsRequest = SearchLocationsRequest(query)
            try {
                val searchLocationsResponse = apiCalls.searchLocations(searchLocationsRequest)

                // Map to db entity
                val entity = searchLocationsResponse.toLocationQueryEntity(query)

                // put and return from db
                dao.insertLocationQuery(entity)
                emit(Resource.Success(dao.getLocationQuery(query).hotelQueryList))
            } catch (e: HttpException) {
                emit(Resource.Error("Failed due to HttpException: ${e.message}"))
            } catch (e: IOException) {
                emit(Resource.Error("Failed due to IOException: ${e.message}"))
            }
        }

    override suspend fun getHotelsList(geoId: Int, updateToken: String): Flow<Resource<HotelList>> =
        flow {
            emit(Resource.Loading())
            // query db and check if present
            if (dao.doesHotelsListExist(geoId)) {
                emit(Resource.Success(dao.getHotelList(geoId).toHotelList()))
            }

            // Fetch from server
            val listHotelsRequest = ListHotelsRequest(geoId)
            try {
                val listHotelsResponse = apiCalls.listHotels(listHotelsRequest)

                // Map to db entity
                val entity = listHotelsResponse.toHotelListEntity(geoId)

                // put and return from db
                dao.insertHotelList(entity)
                emit(Resource.Success(dao.getHotelList(geoId, entity.updateToken).toHotelList()))
            } catch (e: HttpException) {
                emit(Resource.Error("Failed due to HttpException: ${e.message}"))
            } catch (e: IOException) {
                emit(Resource.Error("Failed due to IOException: ${e.message}"))
            }
        }
}
