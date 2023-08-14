package com.example.hotelsapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                color = Color.Green,
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
    focusRequester: FocusRequester,
    onFocusChange: () -> Unit
) {
    OutlinedTextField(
        value = value, // TODO : Replace with Date
        onValueChange = {},
        modifier = Modifier
            .weight(1f)
            .focusRequester(focusRequester)
            .onFocusChanged {
                onFocusChange()
            },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Transparent
        ),
    )
}
