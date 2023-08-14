package com.example.hotelsapp.util

object ImageUtil {

    fun getImageUrlWithHeightAndWidth(
        url: String,
        width: Int,
        height: Int
    ): String = url.replace("{width}", width.toString(), false)
        .replace("{height}", height.toString(), false)
}
