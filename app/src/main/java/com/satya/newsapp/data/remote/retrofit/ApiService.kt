package com.satya.newsapp.data.remote.retrofit

import com.satya.newsapp.data.remote.response.ResponseNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    fun getNews(@Query("country") id: String): Call<ResponseNews>

    @GET("top-headlines")
    fun getNewsCategory(@Query("country")id: String, @Query("category") category: String ): Call<ResponseNews>

    @GET("everything")
    fun getSearchNews(@Query("q") query: String, @Query("language") language: String, @Query("sortBy") sortBy: String ) : Call<ResponseNews>
}