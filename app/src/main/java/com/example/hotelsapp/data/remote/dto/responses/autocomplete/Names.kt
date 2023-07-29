package com.example.hotelsapp.data.remote.dto.responses.autocomplete


import com.google.gson.annotations.SerializedName

data class Names(
    @SerializedName("longOnlyHierarchyTypeaheadV2")
    val longOnlyHierarchyTypeaheadV2: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("__typename")
    val typename: String
)