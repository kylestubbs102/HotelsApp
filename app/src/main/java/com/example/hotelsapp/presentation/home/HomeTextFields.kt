package com.example.hotelsapp.presentation.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun LocationTextField(
    queryTextFieldValue: TextFieldValue,
    focusRequester: FocusRequester,
    onValueChange: (TextFieldValue) -> Unit,
    onFocusChange: (FocusState) -> Unit
) {
    OutlinedTextField(
        value = queryTextFieldValue,
        onValueChange = {
            onValueChange(it)
        },
        modifier = Modifier
            .focusRequester(focusRequester)
            .onFocusChanged { focusState ->
                onFocusChange(focusState)
            }
            .background(
                color = Color(0xFFF6F6F6),
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth(),
        maxLines = 1,
        placeholder = { Text(text = "Location") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Transparent
        )
    )
}

@Composable
fun RowScope.DateTextField(
    value: String,
    placeholder: String,
    onFocusChange: (FocusState) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = {},
        modifier = Modifier
            .weight(1f)
            .onFocusChanged {
                onFocusChange(it)
            },
        placeholder = { Text(text = placeholder) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
    )
}
