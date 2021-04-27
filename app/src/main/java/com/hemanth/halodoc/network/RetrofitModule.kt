package com.hemanth.halodoc.network

import com.hemanth.halodoc.data.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val API_BASE_URL = "https://hn.algolia.com/api/v1/"

object RetrofitModule {


    var retrofit = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create()
        ).client(OkHttpClient.Builder().build())
        .build()

    var client: ApiService = retrofit.create(ApiService::class.java)
}
