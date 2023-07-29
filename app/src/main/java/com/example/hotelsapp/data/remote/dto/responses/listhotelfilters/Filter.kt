package com.example.hotelsapp.data.remote.dto.responses.listhotelfilters


import com.google.gson.annotations.SerializedName

data class Filter(
    @SerializedName("collapsed")
    val collapsed: Boolean?,
    @SerializedName("filterType")
    val filterType: String?,
    @SerializedName("locations")
    val locations: List<Location>?,
    @SerializedName("maxDistance")
    val maxDistance: Double?,
    @SerializedName("maxValue")
    val maxValue: Double?,
    @SerializedName("minDistance")
    val minDistance: Double?,
    @SerializedName("minValue")
    val minValue: Double?,
    @SerializedName("name")
    val name: String,
    @SerializedName("selectedDistance")
    val selectedDistance: Double?,
    @SerializedName("selectedRangeEnd")
    val selectedRangeEnd: Double?,
    @SerializedName("selectedRangeStart")
    val selectedRangeStart: Double?,
    @SerializedName("surfaces")
    val surfaces: List<String>,
    @SerializedName("title")
    val title: String,
    @SerializedName("tooltip")
    val tooltip: Any?,
    @SerializedName("trackingKey")
    val trackingKey: String,
    @SerializedName("trackingTitle")
    val trackingTitle: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("unitFormat")
    val unitFormat: UnitFormat?,
    @SerializedName("values")
    val values: List<Value>?
)