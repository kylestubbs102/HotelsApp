package com.example.hotelsapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HotelReviewEntity(
    @PrimaryKey @ColumnInfo(name = "rid") val rid: String,
    @ColumnInfo(name = "contentId") val contentId: String,
    @ColumnInfo(name = "review") val review: String,
    @ColumnInfo(name = "date") val date: String, // ex: August 2013
    @ColumnInfo(name = "username") val username: String, // ex: By kylestubbs102
    @ColumnInfo(name = "avatarUrlTemplate") val avatarUrlTemplate: String,
    @ColumnInfo(name = "lastModified") val lastModified: Long,
)
