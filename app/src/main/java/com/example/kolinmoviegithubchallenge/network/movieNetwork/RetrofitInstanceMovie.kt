package com.example.kolinmoviegithubchallenge.network.movieNetwork

import com.example.kolinmoviegithubchallenge.common.constants.MovieConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstanceMovie {

    val retrofitInstance: Retrofit
    get(){

        val loggingIntercepter = HttpLoggingInterceptor()
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingIntercepter)
            .build()
        loggingIntercepter.level = HttpLoggingInterceptor.Level.BODY

        return Retrofit.Builder()
            .baseUrl(MovieConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}