package com.satya.newsapp.data.local.model

import com.google.gson.annotations.SerializedName
import com.satya.newsapp.data.remote.response.Source
import kotlinx.android.parcel.RawValue

data class NewsEntity(

    val publishedAt: String,


    val author: String,


    val urlToImage: String,


    val description: String,


    val source: @RawValue Source,


    val title: String,


    val url: String,


    val content: String

)
