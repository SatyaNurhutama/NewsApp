package com.satya.newsapp.data

import androidx.lifecycle.LiveData
import com.satya.newsapp.data.local.model.NewsEntity
import com.satya.newsapp.vo.Resource

interface NewsDataSource {
    fun getNews(): LiveData<Resource<NewsEntity>>
}