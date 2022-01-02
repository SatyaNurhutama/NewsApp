package com.satya.newsapp.data.remote

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.satya.newsapp.BuildConfig
import com.satya.newsapp.data.remote.response.ArticlesItem
import com.satya.newsapp.data.remote.response.ResponseNews
import com.satya.newsapp.data.remote.retrofit.ApiConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException

class RemoteDataSource {

    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null
        private const val COUNTRY = "id"
        private const val API_KEY = BuildConfig.NewsAppApi

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this){
            instance ?: RemoteDataSource()
        }
    }

    fun getNews() : LiveData<ApiResponse<List<ArticlesItem>>>{
        val resultNews = MutableLiveData<ApiResponse<List<ArticlesItem>>>()
        CoroutineScope(IO).launch {
            try{
                val response = ApiConfig.getApiNews().getNews(COUNTRY).await()
                resultNews.postValue(ApiResponse.success(response.articles))
            } catch (e: IOException){
                Log.e(TAG, e.message.toString())
                resultNews.postValue(ApiResponse.error(e.message.toString(), mutableListOf()))
            }
        }
        return resultNews
    }

}