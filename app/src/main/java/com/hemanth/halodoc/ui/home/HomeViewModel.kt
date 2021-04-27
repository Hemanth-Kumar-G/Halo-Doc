package com.hemanth.halodoc.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hemanth.halodoc.data.model.NewsPOJO
import com.hemanth.halodoc.data.repository.HomeRepository
import com.hemanth.halodoc.data.repositoryImpl.HomeRepositoryImpl
import com.hemanth.halodoc.util.Constants
import com.hemanth.halodoc.util.Event
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "HomeViewModel"

class HomeViewModel : ViewModel() {


    val newsList = ArrayList<NewsPOJO.Hit>()

    private val homeRepository: HomeRepository = HomeRepositoryImpl()

    private val event_ = MutableLiveData<Event<Pair<String, *>>>()
    val event: LiveData<Event<Pair<String, *>>> = event_

    fun fetchNews(search: String) {
        event_.postValue(Event(Pair(Constants.LOADING, Unit)))

        homeRepository.fetchNews(search).enqueue(object : Callback<NewsPOJO> {
            override fun onResponse(call: Call<NewsPOJO>, response: Response<NewsPOJO>) {
                Log.e(TAG, "onResponse: ${response.body()}")
                newsList.clear()
                response.body()?.let { newsList.addAll(it.hits) }
                event_.postValue(Event(Pair(Constants.SUCCESS, Unit)))
            }

            override fun onFailure(call: Call<NewsPOJO>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
                event_.postValue(Event(Pair(Constants.ERROR, t.message)))
            }

        })
    }

}
