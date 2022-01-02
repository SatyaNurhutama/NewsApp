package com.satya.newsapp.data.remote.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {

    companion object{
        fun getApiNews() : ApiService {
            val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val queryParamInterceptor = Interceptor { chain ->
                val original = chain.request()
                val originalHttpUrl = original.url
                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("apiKey", "033ad51675c54a2e8f4d42789df28501")
                    .build()

                val requestBuilder = original.newBuilder().url(url)
                val request = requestBuilder.build()
                chain.proceed(request)
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(queryParamInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)

        }
    }

}