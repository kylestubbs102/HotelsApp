package com.example.hotelsapp.data.local

import androidx.room.TypeConverter
import com.example.hotelsapp.domain.model.LocationQueryRow
import com.google.gson.Gson

object HotelConverters {

    @TypeConverter
    fun listToJson(value: List<LocationQueryRow>): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String): List<LocationQueryRow> =
        Gson().fromJson(value, Array<LocationQueryRow>::class.java).toList()
}