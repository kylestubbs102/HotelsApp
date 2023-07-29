package com.example.hotelsapp.util

import com.example.hotelsapp.data.remote.dto.common.Units
import java.text.NumberFormat
import java.util.Locale

object LocaleUtil {

    fun getCurrency(): String? = NumberFormat.getCurrencyInstance().currency?.currencyCode

    fun getUnits(): String =
        when (Locale.getDefault().country) {
            "US", "LR", "MM" -> Units.mi.name // USA, Liberia, Myanmar
            else -> Units.km.name
        }

    fun getLang(): String = Locale.getDefault().toString()
}
