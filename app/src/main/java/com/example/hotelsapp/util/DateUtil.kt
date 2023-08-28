package com.example.hotelsapp.util

import java.text.SimpleDateFormat
import java.util.Locale

object DateUtil {

    private const val DATE_FORMAT = "yyyy-MM-dd"
    private const val MILLIS_PER_DAY = 86400000

    fun getDateFormatStringFromMillis(millis: Long): String {
        // Need to add one day for millis for date to be formatted correctly
        val correctMillis = millis + MILLIS_PER_DAY
        return SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
            .format(correctMillis)
    }
}
