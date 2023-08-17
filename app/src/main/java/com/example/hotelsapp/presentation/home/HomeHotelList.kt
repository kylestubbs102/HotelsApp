package com.example.hotelsapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.GlideLazyListPreloader
import com.example.hotelsapp.domain.model.HotelRow
import com.example.hotelsapp.presentation.navigation.NavRoute
import com.example.hotelsapp.util.ImageUtil

private const val IMAGE_HEIGHT = 500F
private const val IMAGE_WIDTH = 500F

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HotelResultsLazyColumn(
    navController: NavController,
    hotelListState: HomeHotelListState,
) {
    val state = rememberLazyListState()

    if (hotelListState.isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        state = state
    ) {
        items(hotelListState.hotelRows) { hotelRow ->
            HotelDisplayRow(
                navController = navController,
                hotelRow = hotelRow
            )
        }
    }

    GlideLazyListPreloader(
        state = state,
        data = hotelListState.hotelRows.map {
            ImageUtil.getImageUrlWithHeightAndWidth(
                it.photoUrl ?: "",
                IMAGE_HEIGHT.toInt(),
                IMAGE_WIDTH.toInt()
            )
        },
        size = Size(IMAGE_WIDTH, IMAGE_HEIGHT),
        numberOfItemsToPreload = hotelListState.hotelRows.size,
    ) { item, requestBuilder ->
        requestBuilder.load(item)
    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HotelDisplayRow(
    navController: NavController = rememberNavController(),
    hotelRow: HotelRow,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(
                color = Color.Gray,
                shape = RoundedCornerShape(10.dp)
            )
            .height(120.dp)
            .clickable {
                navController.navigate(NavRoute.HotelDetail.path + "/${hotelRow.contentId}")
            }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        GlideImage(
            model = ImageUtil.getImageUrlWithHeightAndWidth(
                hotelRow.photoUrl ?: "",
                IMAGE_HEIGHT.toInt(),
                IMAGE_WIDTH.toInt()
            ),
            contentDescription = "Hotel picture",
            alignment = Alignment.CenterStart,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .size(100.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            if (hotelRow.rating != null) {
                Row(
                    modifier = Modifier.align(alignment = Alignment.TopEnd)
                ) {
                    Text(text = "Rating: ${hotelRow.rating}")
                    Text(text = " (${hotelRow.numberOfReviews.toString()})")
                }
            }
            Text(
                text = hotelRow.hotel,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.align(alignment = Alignment.CenterStart),
            )
        }
    }
}
