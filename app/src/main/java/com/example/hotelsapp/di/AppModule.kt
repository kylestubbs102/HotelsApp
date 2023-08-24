package com.example.hotelsapp.di

import android.app.Application
import androidx.room.Room
import com.example.hotelsapp.BuildConfig
import com.example.hotelsapp.data.local.HotelsDao
import com.example.hotelsapp.data.local.HotelsDatabase
import com.example.hotelsapp.data.remote.AuthInterceptor
import com.example.hotelsapp.data.remote.HotelsApi
import com.example.hotelsapp.data.remote.HotelsApi.Companion.HOTELS_BASE_URL
import com.example.hotelsapp.data.remote.HotelsCalls
import com.example.hotelsapp.data.remote.HotelsCallsImpl
import com.example.hotelsapp.data.repository.HotelDetailsRepositoryImpl
import com.example.hotelsapp.data.repository.HotelsRepositoryImpl
import com.example.hotelsapp.domain.repository.HotelDetailsRepository
import com.example.hotelsapp.domain.repository.HotelsRepository
import com.example.hotelsapp.domain.usecase.FetchAndCacheHotelDetailsUseCase
import com.example.hotelsapp.domain.usecase.GetCachedHotelDetailsUseCase
import com.example.hotelsapp.domain.usecase.GetCachedHotelPhotosUseCase
import com.example.hotelsapp.domain.usecase.GetCachedHotelReviewsUseCase
import com.example.hotelsapp.domain.usecase.GetHotelRowInfoUseCase
import com.example.hotelsapp.domain.usecase.GetLocationQueryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    companion object {
        private const val TIMEOUT_SECONDS = 200L
        private const val TIMEOUT_SECONDS_DEBUG = 200L
    }

    @Provides
    @Singleton
    fun provideHotelsApi(): HotelsApi {
        val timeout = if (BuildConfig.DEBUG) TIMEOUT_SECONDS_DEBUG else TIMEOUT_SECONDS

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .addInterceptor(AuthInterceptor())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(HOTELS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HotelsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHotelsCalls(hotelsApi: HotelsApi): HotelsCalls = HotelsCallsImpl(hotelsApi)

    @Provides
    @Singleton
    fun provideHotelsDatabase(app: Application): HotelsDatabase =
        Room.databaseBuilder(
            app,
            HotelsDatabase::class.java,
            HotelsDatabase.DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideHotelsDao(db: HotelsDatabase): HotelsDao = db.hotelsDao

    @Provides
    @Singleton
    fun provideHotelsRepository(
        dao: HotelsDao,
        apiCalls: HotelsCalls
    ): HotelsRepository = HotelsRepositoryImpl(dao, apiCalls)

    @Provides
    @Singleton
    fun provideHotelDetailsRepository(
        dao: HotelsDao,
        apiCalls: HotelsCalls
    ): HotelDetailsRepository = HotelDetailsRepositoryImpl(dao, apiCalls)

    @Provides
    @Singleton
    fun provideFetchAndCacheHotelDetailsUseCase(
        hotelDetailsRepository: HotelDetailsRepository
    ): FetchAndCacheHotelDetailsUseCase = FetchAndCacheHotelDetailsUseCase(hotelDetailsRepository)

    @Provides
    @Singleton
    fun provideGetCachedHotelPhotosUseCase(
        hotelDetailsRepository: HotelDetailsRepository
    ): GetCachedHotelPhotosUseCase = GetCachedHotelPhotosUseCase(hotelDetailsRepository)

    @Provides
    @Singleton
    fun provideGetHotelRowInfoUseCase(
        hotelsDao: HotelsDao
    ): GetHotelRowInfoUseCase = GetHotelRowInfoUseCase(hotelsDao)

    @Provides
    @Singleton
    fun provideGetLocationQueryUseCase(
        hotelsDao: HotelsDao
    ): GetLocationQueryUseCase = GetLocationQueryUseCase(hotelsDao)

    @Provides
    @Singleton
    fun provideGetCachedHotelDetailsUseCase(
        hotelDetailsRepository: HotelDetailsRepository
    ): GetCachedHotelDetailsUseCase = GetCachedHotelDetailsUseCase(hotelDetailsRepository)

    @Provides
    @Singleton
    fun provideGetCachedHotelReviewsUseCase(
        hotelDetailsRepository: HotelDetailsRepository
    ): GetCachedHotelReviewsUseCase = GetCachedHotelReviewsUseCase(hotelDetailsRepository)
}
