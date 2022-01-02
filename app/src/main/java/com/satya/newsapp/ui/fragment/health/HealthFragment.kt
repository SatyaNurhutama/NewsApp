package com.satya.newsapp.ui.fragment.health

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.satya.newsapp.databinding.FragmentHealthBinding
import com.satya.newsapp.ui.fragment.allnews.BeritaAdapter


class HealthFragment : Fragment() {

    private lateinit var binding : FragmentHealthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHealthBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[HealthViewModel::class.java]
        viewModel.getListNewsHealth()

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