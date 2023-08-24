package com.example.hotelsapp.presentation.hoteldetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.hotelsapp.domain.model.HotelReviewRow
import com.example.hotelsapp.util.ImageUtil

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HotelDetailReviews(hotelReviews: List<HotelReviewRow>) {

    Text(
        text = "Reviews",
        modifier = Modifier.padding(vertical = 10.dp),
        fontWeight = FontWeight.Bold,
    )

    Column {
        hotelReviews.forEach {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                GlideImage(
                    model = ImageUtil.getImageUrlWithHeightAndWidth(
                        it.avatarUrlTemplate,
                        200,
                        200
                    ),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(
                            RoundedCornerShape(50.dp)
                        )
                )
                Column(modifier = Modifier.padding(start = 10.dp)) {
                    Row {
                        Text(text = it.username)
                        Spacer(modifier = Modifier.weight(1F))
                        Text(text = it.date)
                    }
                    Text(
                        text = it.review,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(top = 5.dp)
                    )
                }
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp), color = Color.Transparent
            )
        }
    }
}
