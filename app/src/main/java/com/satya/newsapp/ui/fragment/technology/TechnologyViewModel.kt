package com.satya.newsapp.ui.fragment.technology

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.satya.newsapp.ui.fragment.allnews.HomeViewModel
import com.satya.newsapp.data.remote.response.ArticlesItem
import com.satya.newsapp.data.remote.response.ResponseNews
import com.satya.newsapp.data.remote.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TechnologyViewModel : ViewModel() {

    private val _listNews = MutableLiveData<List<ArticlesItem>>()
    val listNews: LiveData<List<ArticlesItem>> = _listNews

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    companion object{
        const val CATEGORY: String = "technology"
    }

    fun getListNewsTechnology(){
        _isLoading.value = true
        val client = ApiConfig.getApiNews().getNewsCategory(HomeViewModel.COUNTRY, CATEGORY)
        client.enqueue(object : Callback<ResponseNews> {
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                _isLoading.value = false
                _listNews.value = response.body()?.articles
                Log.e(TAG, "$response")
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "Error : ${t.message}")
            }

        })
    }

}