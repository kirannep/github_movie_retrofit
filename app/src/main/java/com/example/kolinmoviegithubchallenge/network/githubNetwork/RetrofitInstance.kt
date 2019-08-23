package com.example.kolinmoviegithubchallenge.network.githubNetwork

import com.example.kolinmoviegithubchallenge.common.constants.GithubConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    val retrofitInstance: Retrofit
    get(){

        val loggingIntercepter = HttpLoggingInterceptor()
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingIntercepter)
            .build()
        loggingIntercepter.level = HttpLoggingInterceptor.Level.BODY

        return Retrofit.Builder()
            .baseUrl(GithubConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}