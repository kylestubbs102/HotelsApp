package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class RatingCountsV2(
    @SerializedName("averageBar")
    val averageBar: AverageBar,
    @SerializedName("excellentBar")
    val excellentBar: ExcellentBar,
    @SerializedName("poorBar")
    val poorBar: PoorBar,
    @SerializedName("terribleBar")
    val terribleBar: TerribleBar,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("veryGoodBar")
    val veryGoodBar: VeryGoodBar
)