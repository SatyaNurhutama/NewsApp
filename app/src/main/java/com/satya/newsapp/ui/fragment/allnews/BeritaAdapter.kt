package com.satya.newsapp.ui.fragment.allnews

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.satya.newsapp.ui.DetailActivity
import com.satya.newsapp.databinding.ItemListBinding
import com.satya.newsapp.data.remote.response.ArticlesItem

class BeritaAdapter(private val fragment: Fragment, private val list : List<ArticlesItem>) : RecyclerView.Adapter<BeritaAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data)

    }

    override fun getItemCount(): Int = list.size

    inner class ListViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: ArticlesItem) {
            with(binding) {
                tvTitle.text = news.title
                tvSource.text = news.source.name
                tvDate.text = news.publishedAt
            }

            Glide.with(itemView.context)
                    .load(news.urlToImage)
                    .into(binding.imgNews)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                        .putExtra("get_title", news.title)
                        .putExtra("get_image", news.urlToImage)
                        .putExtra("get_content", news.content)
                        .putExtra("get_description", news.description)
                        //.putExtra("get_data", news.publishedAt)

                itemView.context.startActivity(intent)
            }
        }
    }


}