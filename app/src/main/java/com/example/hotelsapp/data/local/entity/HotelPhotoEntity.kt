package com.example.hotelsapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HotelPhotoEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "contentId") val contentId: String,
    @ColumnInfo(name = "caption") val caption: String,
    @ColumnInfo(name = "thumbsUpVotes") val thumbsUpVotes: Int,
    @ColumnInfo(name = "publishedDateTime") val publishedDateTime: String,
    @ColumnInfo(name = "uploadDateTime") val uploadDateTime: String,
    @ColumnInfo(name = "urlTemplate") val urlTemplate: String,
    @ColumnInfo(name = "maxHeight") val maxHeight: Int,
    @ColumnInfo(name = "maxWidth") val maxWidth: Int,
    @ColumnInfo(name = "lastModified") val lastModified: Long,
)
