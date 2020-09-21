package org.step.students.domain.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.step.students.presentation.interfaces.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class Api {

    lateinit var retrofit: Retrofit

    companion object {
        var baseURL = "https://api.exchangeratesapi.io/"
        var latest = "latest"
    }

    fun initializeRetrofit(): Retrofit {
        retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(initializeOkHttpClient())
            .build()

        return retrofit
    }

    fun initializeAPI(): ApiInterface {
        return initializeRetrofit().create(ApiInterface::class.java)
    }

    fun initializeOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .addInterceptor(initializeHttpLogging())
            .build()
        return client
    }

    fun initializeHttpLogging(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}