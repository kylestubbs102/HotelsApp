package com.example.hotelsapp.di

import com.example.hotelsapp.data.remote.AuthInterceptor
import com.example.hotelsapp.data.remote.HotelsApi
import com.example.hotelsapp.data.remote.HotelsCalls
import com.example.hotelsapp.data.remote.HotelsCallsImpl
import com.example.hotelsapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideHotelsApi(): HotelsApi {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constants.HOTELS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HotelsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHotelsCalls(
        hotelsApi: HotelsApi
    ): HotelsCalls = HotelsCallsImpl(hotelsApi)
}
