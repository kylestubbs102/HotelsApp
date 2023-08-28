package com.example.hotelsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hotelsapp.data.local.entity.HotelDetailsEntity
import com.example.hotelsapp.data.local.entity.HotelPhotoEntity
import com.example.hotelsapp.data.local.entity.HotelReviewEntity
import com.example.hotelsapp.data.local.entity.HotelRowEntity
import com.example.hotelsapp.data.local.entity.LocationQueryEntity

@Dao
interface HotelsDao {

    // Query results
    @Query("SELECT * FROM locationqueryentity WHERE `query` = :query ORDER BY `index`")
    suspend fun getLocationQueryList(query: String): List<LocationQueryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocationQueryList(locationQueryEntityList: List<LocationQueryEntity>)

    @Query("SELECT EXISTS(SELECT * FROM locationqueryentity WHERE `query` = :query)")
    suspend fun doesQueryExist(query: String): Boolean

    @Query("SELECT * FROM locationqueryentity WHERE geoId = :geoId")
    suspend fun getLocationQueryFromGeoId(geoId: Int): LocationQueryEntity

    // Hotels list results
    @Query("SELECT * FROM hotelrowentity WHERE geoId = :geoId ORDER BY lastModified")
    suspend fun getHotelRowList(geoId: Int): List<HotelRowEntity>

    @Query("SELECT * FROM hotelrowentity WHERE geoId = :geoId AND checkIn = :checkIn AND checkOut = :checkOut ORDER BY lastModified")
    suspend fun getHotelRowList(geoId: Int, checkIn: String, checkOut: String): List<HotelRowEntity>

    @Query("SELECT * FROM hotelrowentity WHERE geoId = :geoId AND checkIn = :checkIn AND checkOut = :checkOut AND updateToken = :updateToken ORDER BY lastModified")
    suspend fun getHotelRowList(
        geoId: Int,
        checkIn: String,
        checkOut: String,
        updateToken: String
    ): List<HotelRowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotelRowList(hotelRowList: List<HotelRowEntity>)

    @Query("SELECT EXISTS(SELECT * FROM hotelrowentity WHERE geoId = :geoId AND checkIn = :checkIn AND checkOut = :checkOut)")
    suspend fun doesHotelsListExist(geoId: Int, checkIn: String, checkOut: String): Boolean

    @Query("SELECT * FROM hotelrowentity WHERE contentId = :contentId")
    suspend fun getHotelRowFromContentId(contentId: String): HotelRowEntity

    // Hotel photos
    @Query("SELECT * FROM hotelphotoentity WHERE contentId = :contentId ORDER BY lastModified")
    suspend fun getHotelPhotoList(contentId: String): List<HotelPhotoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotelPhotoList(hotelPhotoList: List<HotelPhotoEntity>)

    @Query("SELECT EXISTS(SELECT * FROM hotelphotoentity WHERE contentId = :contentId)")
    suspend fun doesHotelPhotoListExist(contentId: String): Boolean

    // Hotel details
    @Query("SELECT * FROM hoteldetailsentity WHERE contentId = :contentId")
    suspend fun getHotelDetails(contentId: String): HotelDetailsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotelDetails(hotelDetails: HotelDetailsEntity)

    @Query("SELECT EXISTS(SELECT * FROM hoteldetailsentity WHERE contentId = :contentId)")
    suspend fun doHotelDetailsExist(contentId: String): Boolean

    // Hotel reviews
    @Query("SELECT * FROM hotelreviewentity WHERE contentId = :contentId ORDER BY lastModified")
    suspend fun getHotelReviewList(contentId: String): List<HotelReviewEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotelReviewList(hotelRowList: List<HotelReviewEntity>)

    @Query("SELECT EXISTS(SELECT * FROM hotelreviewentity WHERE contentId = :contentId)")
    suspend fun doesHotelReviewListExist(contentId: String): Boolean
}