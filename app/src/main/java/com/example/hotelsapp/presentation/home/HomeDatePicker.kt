package com.example.hotelsapp.presentation.home

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hotelsapp.util.DateUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeDatePicker(
    onConfirm: (String, String) -> Unit,
    onDismiss: () -> Unit,
) {
    val dateRangePickerState = rememberDateRangePickerState()
    val confirmEnabled by remember {
        derivedStateOf {
            dateRangePickerState.selectedStartDateMillis != null && dateRangePickerState.selectedEndDateMillis != null
        }
    }
    DatePickerDialog(
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onDismissRequest.
            onDismiss()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    val startDate = DateUtil.getDateFormatStringFromMillis(dateRangePickerState.selectedStartDateMillis!!)
                    val endDate = DateUtil.getDateFormatStringFromMillis(dateRangePickerState.selectedEndDateMillis!!)
                    onConfirm(startDate, endDate)
                },
                enabled = confirmEnabled
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismiss()
                }
            ) {
                Text("Cancel")
            }
        }
    ) {
        DateRangePicker(state = dateRangePickerState, modifier = Modifier.heightIn(0.dp, 500.dp))
    }
}
