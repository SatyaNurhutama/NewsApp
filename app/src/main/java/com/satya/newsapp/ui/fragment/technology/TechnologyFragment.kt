package com.satya.newsapp.ui.fragment.technology

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.satya.newsapp.databinding.FragmentTechnologyBinding
import com.satya.newsapp.ui.fragment.allnews.BeritaAdapter

class TechnologyFragment : Fragment() {

    private lateinit var binding: FragmentTechnologyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTechnologyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this)[TechnologyViewModel::class.java]
        viewModel.getListNewsTechnology()

        viewModel.listNews.observe(viewLifecycleOwner, {
            val adapter = BeritaAdapter(this, it)
            binding.rvNews.layoutManager = LinearLayoutManager(context)
            binding.rvNews.setHasFixedSize(true)
            binding.rvNews.adapter = adapter
        })

        viewModel.isLoading.observe(viewLifecycleOwner, {
            binding.progressBar.visibility = if(it) View.VISIBLE else View.GONE
        })
    }
}