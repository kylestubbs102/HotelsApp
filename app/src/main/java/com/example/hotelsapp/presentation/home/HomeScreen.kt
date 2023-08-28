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
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hotelsapp.R
import com.example.hotelsapp.presentation.navigation.NavRoute

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {

    val queryState = viewModel.queryState.collectAsState().value
    val hotelListState = viewModel.hotelListState.collectAsState().value

    var queryTextFieldValue by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(""))
    }

    var showDatePicker by remember {
        mutableStateOf(false)
    }

    val focusRequester = remember {
        FocusRequester()
    }

    val focusManager = LocalFocusManager.current

    Scaffold(
        floatingActionButton = {
            if (hotelListState.hotelRows.isNotEmpty()) {
                FloatingActionButton(onClick = {
                    navController.navigate(NavRoute.HotelsMap.path + "/${hotelListState.hotelRows.first().geoId}")
                }, containerColor = Color.Black) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_outline_map_24),
                        contentDescription = "Map icon",
                        tint = Color.White,
                    )
                }
            }
        }
    ) {
        Column(modifier = Modifier.fillMaxHeight()) {
            // Hide when loading, and when rows are populated
            AnimatedVisibility(
                visible = (hotelListState.isLoading.not() && hotelListState.hotelRows.isEmpty()) || hotelListState.hotelRows.isEmpty(),
                enter = slideInVertically(),
                exit = shrinkVertically()
            ) {
                Text(
                    text = "Find the perfect hotel",
                    modifier = Modifier.padding(20.dp, 50.dp, 20.dp, 10.dp),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 50.sp
                )
            }
            Box {
                Column(
                    modifier = Modifier
                        .padding(20.dp, 10.dp)
                        .shadow(5.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .padding(10.dp)

                ) {
                    LocationTextField(
                        queryTextFieldValue,
                        focusRequester,
                        onValueChange = { textFieldValue ->
                            // Don't reset text when setting it to the selection
                            if (queryState.querySelection.toString() != textFieldValue.text) {
                                queryTextFieldValue = textFieldValue
                                viewModel.clearQuerySelection()
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
                                color = Color(0xFFF6F6F6),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .fillMaxWidth()
                    ) {
                        DateTextField(queryState.dates.first, "Check-in") {
                            queryTextFieldValue =
                                queryTextFieldValue.copy(selection = TextRange(0, 0))
                            showDatePicker = it.hasFocus
                        }
                        DateTextField(queryState.dates.second, "Check-out") {
                            queryTextFieldValue =
                                queryTextFieldValue.copy(selection = TextRange(0, 0))
                            showDatePicker = it.hasFocus
                        }
                    }

                    val buttonIsClickable = queryState.querySelection != null
                            && queryState.dates.first.isNotEmpty()
                            && queryState.dates.second.isNotEmpty()

                    Button(
                        onClick = {
                            queryState.querySelection?.geoId?.let {
                                viewModel.searchHotelsList(
                                    it,
                                    true
                                )
                            }
                            focusManager.clearFocus()
                        },
                        enabled = buttonIsClickable,
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
                QueryLazyColumn(queryState.queryRows) { queryRow ->
                    queryTextFieldValue =
                        TextFieldValue(queryRow.toString())
                    viewModel.setQuerySelection(queryRow)
                }
            }
            HotelResultsLazyColumn(navController, hotelListState)
        }
    }

    if (showDatePicker) {
        HomeDatePicker(
            onConfirm = { startDate, endDate ->
                showDatePicker = false
                viewModel.setSearchQueryDates(startDate, endDate)
            }, onDismiss = {
                showDatePicker = false
            }
        )
    }
}
