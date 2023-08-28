package com.example.hotelsapp.presentation.hoteldetail

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelsapp.domain.model.HotelDetails
import com.example.hotelsapp.domain.model.HotelRow
import com.example.hotelsapp.domain.model.LocationQueryRow
import com.example.hotelsapp.util.PhoneUtil

private const val INFINITE_MAX_LINES = 10000
private const val SHRUNK_MAX_LINES = 4

private const val ORANGE_HEX = 0xFFFFA500

@Composable
fun HotelDetailInfo(
    hotelRow: HotelRow?,
    hotelDetails: HotelDetails?,
    locationQueryRow: LocationQueryRow?
) {

    val context = LocalContext.current

    var showDescriptionState by remember {
        mutableStateOf(false)
    }

    Text(
        text = hotelRow?.hotel ?: "",
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        lineHeight = 35.sp,
        modifier = Modifier.padding(top = 15.dp, bottom = 10.dp, start = 5.dp)
    )
    Row(modifier = Modifier.padding(bottom = 10.dp)) {
        Icon(
            Icons.Filled.LocationOn, "Location",
            tint = Color.Black,
            modifier = Modifier.padding(end = 5.dp)
        )
        Text(
            text = (locationQueryRow?.location + ", " + locationQueryRow?.city),
            color = Color.DarkGray,
        )
    }
    Row(modifier = Modifier.padding(bottom = 25.dp)) {
        Icon(
            Icons.Outlined.Star, "Star",
            tint = Color(ORANGE_HEX),
            modifier = Modifier.padding(end = 5.dp)
        )
        Text(text = hotelRow?.rating.toString())
        Text(text = " ")
        Text(text = "(${hotelRow?.numberOfReviews ?: "?"} reviews)")
    }

    Column(modifier = Modifier.padding(bottom = 10.dp)) {
        Text(
            text = hotelDetails?.address ?: "Address unavailable",
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = (PhoneUtil.getPhoneNumberFormatted(hotelDetails?.phoneNumber)
                ?: "Phone number unavailable"),
            color = if (PhoneUtil.isPhoneNumberValid(hotelDetails?.phoneNumber)) Color.Blue else Color.Black,
            modifier = Modifier.clickable {
                if (PhoneUtil.isPhoneNumberValid(hotelDetails?.phoneNumber)) {
                    PhoneUtil.startPhoneDialIntent(hotelDetails?.phoneNumber, context)
                }
            }
        )
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "Description",
            modifier = Modifier.padding(vertical = 10.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.weight(1F))
        Text(
            text = if (showDescriptionState) "Show less" else "Show more",
            color = Color.Blue,
            fontSize = 16.sp,
            modifier = Modifier.clickable {
                showDescriptionState = !showDescriptionState
            }
        )
    }

    Text(
        text = hotelDetails?.description ?: "",
        modifier = Modifier.animateContentSize(),
        maxLines = if (showDescriptionState) INFINITE_MAX_LINES else SHRUNK_MAX_LINES,
        overflow = TextOverflow.Clip
    )
}
