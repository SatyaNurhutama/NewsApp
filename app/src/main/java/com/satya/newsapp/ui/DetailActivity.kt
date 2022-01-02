package com.satya.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.satya.newsapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
    }

    private fun getData(){

        binding.tvTitle.text = intent.getStringExtra("get_title")

        if(intent.getStringExtra("get_content") == null){
            binding.tvContent.text = intent.getStringExtra("get_description")
        } else {
            binding.tvContent.text = intent.getStringExtra("get_content")
        }

        Glide.with(this)
            .load(intent.getStringExtra("get_image"))
            .centerCrop()
            .into(binding.imgNews)
    }
}