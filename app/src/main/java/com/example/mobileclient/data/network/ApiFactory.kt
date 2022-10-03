package com.example.mobileclient.data.network

import androidx.viewbinding.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    private val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(loggingInterceptor)
        .build();

    var gson = GsonBuilder()
        .setLenient()
        .create()


    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(NetConst.BASE_URL)
        .client(okHttpClient)
        .build()

    val apiService = retrofit.create(ApiService::class.java)
}