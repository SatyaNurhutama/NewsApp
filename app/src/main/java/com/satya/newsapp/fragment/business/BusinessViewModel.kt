package com.satya.newsapp.fragment.business

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.satya.newsapp.fragment.home.MainViewModel
import com.satya.newsapp.response.ArticlesItem
import com.satya.newsapp.response.ResponseNews
import com.satya.newsapp.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BusinessViewModel : ViewModel() {

    private val _listNews = MutableLiveData<List<ArticlesItem>>()
    val listNews: LiveData<List<ArticlesItem>> = _listNews

    companion object{
        const val BUSINESS: String = "business"
    }

    fun getListNewsBusiness(){
        val client = ApiConfig.getApiNews().getNewsCategory(
            MainViewModel.COUNTRY,
            BUSINESS
        )
        client.enqueue(object: Callback<ResponseNews> {
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                _listNews.value = response.body()?.articles
                Log.e(ContentValues.TAG, "$response")
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                Log.e(ContentValues.TAG, "Error : ${t.message}")
            }

        })
    }

}