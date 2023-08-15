package com.example.hotelsapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HotelRowEntity(
    @PrimaryKey @ColumnInfo(name = "contentId") val contentId: Int,
    @ColumnInfo(name = "geoId") val geoId: Int,
    @ColumnInfo(name = "hotel") val hotel: String,
    @ColumnInfo(name = "latitude") val latitude: Double,
    @ColumnInfo(name = "longitude") val longitude: Double,
    @ColumnInfo(name = "updateToken") val updateToken: String,
    @ColumnInfo(name = "rating", defaultValue = "NULL") val rating: Double?,
    @ColumnInfo(name = "numberOfReviews", defaultValue = "NULL") val numberOfReviews: String?,
    @ColumnInfo(name = "photoUrl", defaultValue = "NULL") val photoUrl: String?,
    @ColumnInfo(name = "lastModified") val lastModified: Long,
)
