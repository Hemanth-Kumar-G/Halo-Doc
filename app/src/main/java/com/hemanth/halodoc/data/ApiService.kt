package com.hemanth.halodoc.data

import com.hemanth.halodoc.data.model.NewsPOJO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/v1/search")
    fun fetchNews(@Query("query") query: String): Call<NewsPOJO>
}
