package com.example.hotelsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hotelsapp.data.local.entity.HotelListEntity
import com.example.hotelsapp.data.local.entity.LocationQueryEntity

@Dao
interface HotelsDao {

    // Query results
    @Query("SELECT * FROM locationqueryentity WHERE `query` = :query")
    suspend fun getLocationQuery(query: String): LocationQueryEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocationQuery(locationQueryEntity: LocationQueryEntity)

    @Query("SELECT EXISTS(SELECT * FROM locationqueryentity WHERE `query` = :query)")
    suspend fun doesQueryExist(query: String): Boolean

    // Hotels list results
    @Query("SELECT * FROM hotellistentity WHERE geoId = :geoId")
    suspend fun getHotelList(geoId: Int): HotelListEntity

    @Query("SELECT * FROM hotellistentity WHERE geoId = :geoId AND updateToken = :updateToken")
    suspend fun getHotelList(geoId: Int, updateToken: String): HotelListEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotelList(hotelList: HotelListEntity)

    @Query("SELECT EXISTS(SELECT * FROM hotellistentity WHERE geoId = :geoId)")
    suspend fun doesHotelsListExist(geoId: Int): Boolean
}