package com.example.hotelsapp.data.local

import androidx.room.TypeConverter
import com.example.hotelsapp.domain.model.HotelListRow
import com.example.hotelsapp.domain.model.LocationQueryRow
import com.google.gson.Gson

object HotelConverters {

    @TypeConverter
    fun queryListToJson(value: List<LocationQueryRow>): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToQueryList(value: String): List<LocationQueryRow> =
        Gson().fromJson(value, Array<LocationQueryRow>::class.java).toList()

    @TypeConverter
    fun hotelListToJson(value: List<HotelListRow>): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToHotelList(value: String): List<HotelListRow> =
        Gson().fromJson(value, Array<HotelListRow>::class.java).toList()
}