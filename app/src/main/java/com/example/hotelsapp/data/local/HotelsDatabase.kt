package com.example.hotelsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.hotelsapp.data.local.entity.LocationQueryEntity

@Database(
    entities = [LocationQueryEntity::class],
    version = 1
)
@TypeConverters(HotelConverters::class)
abstract class HotelsDatabase : RoomDatabase() {

    abstract val hotelsDao: HotelsDao

    companion object {
        const val DATABASE_NAME = "hotels_db"
    }
}