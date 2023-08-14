package com.example.hotelsapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hotelsapp.domain.model.HotelListRow

@Entity
data class HotelListEntity(
    @PrimaryKey @ColumnInfo(name = "geoId") val geoId: Int,
    @ColumnInfo(name = "hotelRowsList") val hotelRowsList: List<HotelListRow>,
    @ColumnInfo(name = "updateToken") val updateToken: String,
)
