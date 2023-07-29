package com.example.hotelsapp.data.remote.dto.responses.listhotelfilters


import com.google.gson.annotations.SerializedName

data class Value(
    @SerializedName("count")
    val count: Any?,
    @SerializedName("filterName")
    val filterName: String?,
    @SerializedName("isDisabled")
    val isDisabled: Any?,
    @SerializedName("isSelected")
    val isSelected: Boolean,
    @SerializedName("object")
    val objectX: ObjectX,
    @SerializedName("selectedAccessibilityString")
    val selectedAccessibilityString: SelectedAccessibilityString?,
    @SerializedName("tooltip")
    val tooltip: Tooltip?,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("unselectedAccessibilityString")
    val unselectedAccessibilityString: UnselectedAccessibilityString?,
    @SerializedName("value")
    val value: String
)