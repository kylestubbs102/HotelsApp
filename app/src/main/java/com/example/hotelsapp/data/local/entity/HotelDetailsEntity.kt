package com.example.hotelsapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HotelDetailsEntity(
    @PrimaryKey @ColumnInfo(name = "contentId") val contentId: String,
    @ColumnInfo(name = "address", defaultValue = "NULL") val address: String?,
    @ColumnInfo(name = "phoneNumber", defaultValue = "NULL") val phoneNumber: String?,
    @ColumnInfo(name = "description", defaultValue = "NULL") val description: String?,
    @ColumnInfo(name = "lastModified") val lastModified: Long,
)
