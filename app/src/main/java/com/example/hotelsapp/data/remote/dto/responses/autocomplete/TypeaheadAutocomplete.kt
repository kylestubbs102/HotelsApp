package com.example.hotelsapp.data.remote.dto.responses.autocomplete


import com.google.gson.annotations.SerializedName

data class TypeaheadAutocomplete(
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("resultsId")
    val resultsId: String,
    @SerializedName("__typename")
    val typename: String
)