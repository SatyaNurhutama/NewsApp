package com.satya.newsapp.ui.fragment.allnews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.satya.newsapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getListNews()

        viewModel.listNews.observe(viewLifecycleOwner, { news ->
            homeBinding.rv1.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            homeBinding.rv2.layoutManager = LinearLayoutManager(context)
            homeBinding.rv1.setHasFixedSize(true)
            homeBinding.rv2.setHasFixedSize(true)
            val adapter1 = NewsAdapter(this, news)
            val adapter2 = BeritaAdapter(this, news)
            homeBinding.rv1.adapter = adapter1
            homeBinding.rv2.adapter = adapter2
        })

        viewModel.isLoading.observe(viewLifecycleOwner, {
            homeBinding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })
    }
}