package com.example.hotelsapp.presentation.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hotelsapp.domain.model.LocationQueryRow

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {

    var queryTextFieldValue by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(""))
    }

    var currentQuerySelection: LocationQueryRow? by remember {
        mutableStateOf(null)
    }

    var hotelListScreenVisible: Boolean by remember {
        mutableStateOf(false)
    }

    val focusRequester = remember {
        FocusRequester()
    }

    val focusManager = LocalFocusManager.current

    Column(modifier = Modifier.fillMaxHeight()) {
        AnimatedVisibility(
            visible = hotelListScreenVisible.not(),
            enter = slideInVertically(),
            exit = shrinkVertically()
        ) {
            Text(
                text = "Find the perfect hotel",
                modifier = Modifier.padding(20.dp, 50.dp, 20.dp, 10.dp),
                fontSize = 40.sp,
                lineHeight = 50.sp
            )
        }
        Box {
            Column(
                modifier = Modifier
                    .padding(20.dp, 10.dp)
                    .background(color = Color.Gray, shape = RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .padding(10.dp)

            ) {
                LocationTextField(
                    queryTextFieldValue,
                    focusRequester,
                    onValueChange = { textFieldValue ->
                        // Don't reset text when setting it to the selection
                        if (currentQuerySelection.toString() != textFieldValue.text) {
                            queryTextFieldValue = textFieldValue
                            currentQuerySelection = null
                            viewModel.queryLocation(textFieldValue.text)
                        }
                    },
                    onFocusChange = { focusState ->
                        if (focusState.isFocused) {
                            val text = queryTextFieldValue.text
                            queryTextFieldValue = queryTextFieldValue.copy(
                                selection = TextRange(0, text.length)
                            )
                        }
                    }
                )

                Row(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .background(
                            color = Color.Green,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .fillMaxWidth()
                ) {
                    DateTextField("Check-in", focusRequester) {
                        queryTextFieldValue =
                            queryTextFieldValue.copy(selection = TextRange(0, 0))
                    }
                    DateTextField("Check-out", focusRequester) {
                        queryTextFieldValue =
                            queryTextFieldValue.copy(selection = TextRange(0, 0))
                    }
                }
                Button(
                    onClick = {
                        // TODO : animate form up and only show name and check in/out dates
                        //  Also, display the list of hotels found
                        currentQuerySelection?.geoId?.let { viewModel.searchHotelsList(it) }
                        hotelListScreenVisible = true
                        focusManager.clearFocus()
                    },
                    enabled = currentQuerySelection != null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(Color.Black)
                ) {
                    Text(
                        text = "Find"
                    )
                }
            }
            QueryLazyColumn(viewModel.queryState.value.queryRows) { queryRow ->
                queryTextFieldValue =
                    TextFieldValue(queryRow.toString())
                currentQuerySelection = queryRow
                viewModel.clearQuery()
            }
        }
        HotelResultsLazyColumn(viewModel, navController)
    }
}
