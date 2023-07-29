package com.example.hotelsapp.data.remote.dto.responses.autocomplete


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("Typeahead_autocomplete")
    val typeaheadAutocomplete: TypeaheadAutocomplete
)