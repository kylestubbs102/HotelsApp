package com.example.hotelsapp.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.telephony.PhoneNumberUtils
import java.util.Locale


object PhoneUtil {

    fun getPhoneNumberFormatted(phoneNumberUri: String?): String? {
        if (isPhoneNumberValid(phoneNumberUri).not()) return null

        val phoneNumber = phoneNumberUri?.substringAfter(":")

        return PhoneNumberUtils.formatNumber(phoneNumber, Locale.getDefault().country)
    }

    fun isPhoneNumberValid(phoneNumberUri: String?): Boolean =
        phoneNumberUri?.contains("tel:") ?: false

    fun startPhoneDialIntent(phoneNumberUri: String?, context: Context) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse(phoneNumberUri)
        context.startActivity(intent)
    }
}