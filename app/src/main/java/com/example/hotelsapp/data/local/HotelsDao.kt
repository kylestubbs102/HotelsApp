package com.example.hotelsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hotelsapp.data.local.entity.LocationQueryEntity

@Dao
interface HotelsDao {

    @Query("SELECT * FROM locationqueryentity WHERE `query` = :query")
    suspend fun getLocationQuery(query: String): LocationQueryEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocationQuery(pokeEvoEntityList: LocationQueryEntity)

    @Query("SELECT EXISTS(SELECT * FROM locationqueryentity WHERE `query` = :query)")
    suspend fun doesQueryExist(query: String): Boolean
}