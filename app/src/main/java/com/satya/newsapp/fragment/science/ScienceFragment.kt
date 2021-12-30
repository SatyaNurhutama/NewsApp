package com.satya.newsapp.fragment.science

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.satya.newsapp.R
import com.satya.newsapp.databinding.FragmentScienceBinding
import com.satya.newsapp.fragment.home.BeritaAdapter

class ScienceFragment : Fragment() {

    private lateinit var binding: FragmentScienceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScienceBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this)[ScienceViewModel::class.java]
        viewModel.getListNewsScience()

        viewModel.listNews.observe(viewLifecycleOwner, {
            val adapter = BeritaAdapter(this, it)
            binding.rvNews.layoutManager = LinearLayoutManager(context)
            binding.rvNews.setHasFixedSize(true)
            binding.rvNews.adapter =adapter
        })
    }

}