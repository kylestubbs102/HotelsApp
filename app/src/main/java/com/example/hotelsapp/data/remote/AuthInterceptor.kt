package com.example.hotelsapp.data.remote

import com.example.hotelsapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    companion object {
        private const val HEADER_KEY_PARAM = "X-RapidAPI-Key"
        private const val HEADER_AUTH_PARAM = "X-RapidAPI-Host"

        // api key configured through local.properties and gradle
        private const val HEADER_AUTH_VALUE = "travel-advisor.p.rapidapi.com"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        request = request.newBuilder()
            .header(HEADER_KEY_PARAM, BuildConfig.RAPID_API_KEY)
            .header(HEADER_AUTH_PARAM, HEADER_AUTH_VALUE)
            .build()

        return chain.proceed(request)
    }
}
