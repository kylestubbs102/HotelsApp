package com.example.hotelsapp.presentation.map

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.hotelsapp.domain.model.HotelRow
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch

private const val SINGLE_HOTEL_ZOOM = 12F
private const val MULTI_HOTEL_PADDING = 100

@Composable
fun HotelMapScreen(
    navController: NavHostController,
    viewModel: HotelMapViewModel = hiltViewModel(),
) {


    val hotelMapState = viewModel.hotelMapState.collectAsState().value

    val coroutineScope = rememberCoroutineScope()
    val cameraPositionState = rememberCameraPositionState()

    LaunchedEffect(hotelMapState.hotelRowList) {
        if (hotelMapState.hotelRowList.isEmpty()) return@LaunchedEffect

        if (hotelMapState.hotelRowList.size == 1) {
            updateSingleHotelCameraPosition(hotelMapState.hotelRowList, cameraPositionState)
        } else {
            updateLatLngBounds(hotelMapState.hotelRowList, cameraPositionState)
        }
    }

    if (hotelMapState.isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
    ) {
        hotelMapState.hotelRowList.forEach {
            Marker(
                state = MarkerState(position = LatLng(it.latitude, it.longitude)),
                title = it.hotel,
                snippet = "${it.rating.toString()} (${it.numberOfReviews})",
                onClick = { _ ->
                    coroutineScope.launch {
                        cameraPositionState.animate(
                            CameraUpdateFactory.newCameraPosition(
                                CameraPosition(
                                    LatLng(it.latitude, it.longitude),
                                    14f,
                                    0f,
                                    0f
                                )
                            ), durationMs = 800
                        )
                    }

                    // Return false to keep default behavior of showing the markers title and snippet
                    return@Marker false
                }
            )
        }
    }
}

private fun updateSingleHotelCameraPosition(
    hotelRowList: List<HotelRow>,
    cameraPositionState: CameraPositionState
) {
    val maxLong = hotelRowList.maxOf { it.longitude }
    val minLong = hotelRowList.minOf { it.longitude }
    val maxLat = hotelRowList.maxOf { it.latitude }
    val minLat = hotelRowList.minOf { it.latitude }

    val targetLong = (maxLong + minLong) / 2
    val targetLat = (maxLat + minLat) / 2

    cameraPositionState.move(
        CameraUpdateFactory.newCameraPosition(
            CameraPosition(LatLng(targetLat, targetLong), SINGLE_HOTEL_ZOOM, 0f, 0f)
        )
    )
}

private fun updateLatLngBounds(
    hotelRowList: List<HotelRow>,
    cameraPositionState: CameraPositionState
) {
    val latLngBoundsBuilder = LatLngBounds.builder();
    hotelRowList.forEach {
        val latLng = LatLng(it.latitude, it.longitude)
        latLngBoundsBuilder.include(latLng)
    }

    cameraPositionState.move(
        CameraUpdateFactory.newLatLngBounds(
            latLngBoundsBuilder.build(), MULTI_HOTEL_PADDING
        )
    )
}
