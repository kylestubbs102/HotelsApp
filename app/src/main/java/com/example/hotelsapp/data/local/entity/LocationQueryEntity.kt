package com.example.hotelsapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["query", "geoId"])
data class LocationQueryEntity(
    @ColumnInfo(name = "query") val query: String,
    @ColumnInfo(name = "geoId") val geoId: Int,
    @ColumnInfo(name = "index") val index: Int,
    @ColumnInfo(name = "location") val location: String,
    @ColumnInfo(name = "city") val city: String,
)

// potentially add more fields when adding filters
// also, maybe add createdDate for TTL, as well as index to help sort
