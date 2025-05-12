package com.pilsa.di

import android.util.Log
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.pilsa.data.api.CalendarApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://www.fillsa.store"

    private const val AUTH_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNzQ2NTk3MjM3LCJleHAiOjE3NTQzNzMyMzd9.ZcigU_0X8P006X-qgBntygM1UqIHgCaHnpA7aqwnblA"

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        encodeDefaults = true
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor { message ->
            Log.d("NetworkLog", message)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }


        val headerInterceptor = Interceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer $AUTH_TOKEN")
                .build()
            chain.proceed(newRequest)
        }

        val customLogger = Interceptor { chain ->
            val request = chain.request()
            Log.d("philsa", "Request: ${request.method} ${request.url}")
            Log.d("philsa","Headers: ${request.headers}")

            val response = chain.proceed(request)

            Log.d("philsa","Response: ${response.code} ${response.message}")
            Log.d("philsa","Response Headers: ${response.headers}")

            response
        }

        return OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(customLogger)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, json: Json): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }


    @Provides
    @Singleton
    fun provideCalendarApiService(retrofit: Retrofit): CalendarApiService {
        return retrofit.create(CalendarApiService::class.java)
    }
}