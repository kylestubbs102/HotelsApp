package com.example.hotelsapp.presentation.hoteldetail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.hotelsapp.R
import com.example.hotelsapp.domain.model.HotelPhoto
import com.example.hotelsapp.presentation.navigation.NavRoute
import com.example.hotelsapp.util.ImageUtil

private const val IMAGE_HEIGHT = 700
private const val IMAGE_WIDTH = 600

@OptIn(ExperimentalFoundationApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun PhotoViewPager(
    hotelPhotoList: List<HotelPhoto>,
    navController: NavController,
    contentId: String
) {
    var hotelLikedState by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        HorizontalPager(
            pageCount = hotelPhotoList.size,
            state = rememberPagerState()
        ) { idx ->
            val hotelPhoto = hotelPhotoList[idx]
            GlideImage(
                model = ImageUtil.getImageUrlWithHeightAndWidth(
                    hotelPhoto.urlTemplate,
                    IMAGE_HEIGHT,
                    IMAGE_WIDTH,
                ),
                contentDescription = hotelPhoto.caption
            ) {
                it.centerCrop()
            }
        }
        IconBox(
            alignment = Alignment.TopStart,
            drawable = R.drawable.ic_baseline_arrow_back_24,
        ) {
            navController.popBackStack()
        }
        IconBox(
            alignment = Alignment.TopEnd,
            drawable = if (hotelLikedState) R.drawable.ic_baseline_favorite_24
            else R.drawable.ic_baseline_favorite_border_24,
            tint = if (hotelLikedState) Color.Red else Color.Black
        ) {
            hotelLikedState = hotelLikedState.not()
        }
        IconBox(
            alignment = Alignment.BottomEnd,
            drawable = R.drawable.ic_outline_map_24
        ) {
            navController.navigate(NavRoute.HotelMap.path + "/${contentId}")
        }
    }
}

@Composable
fun BoxScope.IconBox(
    alignment: Alignment,
    drawable: Int,
    tint: Color = LocalContentColor.current,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(15.dp)
            .align(alignment)
            .background(Color.White, RoundedCornerShape(10.dp))
            .clickable(
                onClick = { onClick() },
                indication = rememberRipple(bounded = true),
                interactionSource = remember { MutableInteractionSource() })
            .padding(10.dp)
    ) {
        Icon(
            painterResource(id = drawable),
            contentDescription = "Favorite button",
            tint = tint
        )
    }
}
