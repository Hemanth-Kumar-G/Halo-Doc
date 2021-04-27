package com.hemanth.halodoc.data.repositoryImpl

import com.hemanth.halodoc.data.model.NewsPOJO
import com.hemanth.halodoc.data.repository.HomeRepository
import com.hemanth.halodoc.network.RetrofitModule
import retrofit2.Call

class HomeRepositoryImpl : HomeRepository {

    override fun fetchNews(search: String): Call<NewsPOJO> {
        return RetrofitModule.client.fetchNews(search)
    }
}
