package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("count")
    val count: Any?,
    @SerializedName("isDisabled")
    val isDisabled: Any?,
    @SerializedName("isSelected")
    val isSelected: Boolean,
    @SerializedName("object")
    val objectX: Object,
    @SerializedName("selectedAccessibilityString")
    val selectedAccessibilityString: SelectedAccessibilityString,
    @SerializedName("tooltip")
    val tooltip: Any?,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("unselectedAccessibilityString")
    val unselectedAccessibilityString: UnselectedAccessibilityString,
    @SerializedName("value")
    val value: String
)