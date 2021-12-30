package com.satya.newsapp.fragment.home

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.satya.newsapp.response.ArticlesItem
import com.satya.newsapp.response.ResponseNews
import com.satya.newsapp.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _listNews = MutableLiveData<List<ArticlesItem>>()
    val listNews: LiveData<List<ArticlesItem>> = _listNews

    companion object{
        const val COUNTRY: String = "id"
    }

    fun getListNews(){
        val client = ApiConfig.getApiNews().getNews(COUNTRY)
        client.enqueue(object: Callback<ResponseNews>{
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                _listNews.value = response.body()?.articles
                Log.e(TAG, "$response")
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                Log.e(TAG, "Error : ${t.message}")
            }

        })
    }

}