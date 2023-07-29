package com.example.hotelsapp.data.remote.dto.responses.listnearby


import com.google.gson.annotations.SerializedName

data class Value(
    @SerializedName("count")
    val count: Int,
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