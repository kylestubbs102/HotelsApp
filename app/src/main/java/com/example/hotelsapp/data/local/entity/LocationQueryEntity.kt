package com.example.hotelsapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hotelsapp.domain.model.LocationQueryRow

@Entity
data class LocationQueryEntity(
    @PrimaryKey @ColumnInfo(name = "query") val query: String,
    @ColumnInfo(name = "hotelQueryList") val hotelQueryList: List<LocationQueryRow>,
)

// potentially add more fields when adding filters
// also, maybe add createdDate for TTL, as well as index to help sort
