package com.example.hotelsapp.di

import android.app.Application
import androidx.room.Room
import com.example.hotelsapp.data.local.HotelsDao
import com.example.hotelsapp.data.local.HotelsDatabase
import com.example.hotelsapp.data.remote.AuthInterceptor
import com.example.hotelsapp.data.remote.HotelsApi
import com.example.hotelsapp.data.remote.HotelsApi.Companion.HOTELS_BASE_URL
import com.example.hotelsapp.data.remote.HotelsCalls
import com.example.hotelsapp.data.remote.HotelsCallsImpl
import com.example.hotelsapp.data.repository.HotelsRepositoryImpl
import com.example.hotelsapp.domain.repository.HotelsRepository
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
}
