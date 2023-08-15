package com.example.hotelsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hotelsapp.data.local.entity.HotelRowEntity
import com.example.hotelsapp.data.local.entity.LocationQueryEntity

@Database(
    entities = [LocationQueryEntity::class, HotelRowEntity::class],
    version = 1
)
abstract class HotelsDatabase : RoomDatabase() {

    abstract val hotelsDao: HotelsDao

    companion object {
        const val DATABASE_NAME = "hotels_db"
    }
}