package com.hemanth.halodoc.data.repository

import com.hemanth.halodoc.data.model.NewsPOJO
import retrofit2.Call


interface HomeRepository {

    fun fetchNews(search: String): Call<NewsPOJO>
}
