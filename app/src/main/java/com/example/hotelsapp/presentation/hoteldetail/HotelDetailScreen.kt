package com.example.hotelsapp.presentation.hoteldetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun HotelDetailScreen(
    navController: NavController,
    viewModel: HotelDetailViewModel = hiltViewModel(),
) {

    val photosState = viewModel.hotelPhotosState.collectAsState().value
    val rowState = viewModel.hotelRowState.collectAsState().value
    val detailState = viewModel.hotelDetailState.collectAsState().value
    val reviewsState = viewModel.hotelReviewState.collectAsState().value

    var showLoadingSpinner by remember {
        mutableStateOf(false)
    }

    var showErrorState by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        viewModel.getHotelDetails()
    }

    LaunchedEffect(photosState, rowState, detailState, reviewsState) {
        showErrorState = photosState.error.isNotBlank()
                || rowState.error.isNotBlank()
                || detailState.error.isNotBlank()
                || reviewsState.error.isNotBlank()

        // If error state is present, remove error spinner
        showLoadingSpinner = showErrorState == false
                && (photosState.isLoading
                || rowState.isLoading
                || detailState.isLoading
                || reviewsState.isLoading)
    }

    if (showLoadingSpinner) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        PhotoViewPager(photosState.hotelPhotoList, navController)

        if (showLoadingSpinner.not()) {
            HotelDetailInfo(
                rowState.hotelRow,
                detailState.hotelDetails,
                detailState.locationQueryRow
            )

            HotelDetailReviews(reviewsState.hotelReviews)
        }
    }
}
