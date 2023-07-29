package com.example.hotelsapp.util

object MapUtil {

    @Suppress("UNCHECKED_CAST")
    fun <K, V> Map<K, V?>.filterOutNullValues(): Map<K, V> =
        this.filterValues { it != null } as Map<K, V>


}
