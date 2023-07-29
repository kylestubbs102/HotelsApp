package com.example.hotelsapp.data.remote.dto.responses.autocomplete


import com.google.gson.annotations.SerializedName

data class NamesX(
    @SerializedName("longOnlyHierarchyTypeaheadV2")
    val longOnlyHierarchyTypeaheadV2: String,
    @SerializedName("__typename")
    val typename: String
)