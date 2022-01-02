package com.satya.newsapp.ui.fragment.bottomnavigation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.satya.newsapp.databinding.FragmentSearchBinding
import com.satya.newsapp.ui.fragment.allnews.BeritaAdapter

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var binding: FragmentSearchBinding
    lateinit var query: String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvNews.layoutManager = LinearLayoutManager(context)
        binding.rvNews.setHasFixedSize(true)
        getNews()

    }

    private fun getNews(){
        val viewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        viewModel.listNews.observe(viewLifecycleOwner,  { news ->
            if(news != null){
                val newsAdapter = BeritaAdapter(this, news)
                newsAdapter.notifyDataSetChanged()
                binding.rvNews.adapter = newsAdapter
            }
        })

        viewModel.isLoading.observe(viewLifecycleOwner, {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
            binding.rvNews.visibility = if (it) View.GONE else View.VISIBLE
        })

        binding.svNews.imeOptions = EditorInfo.IME_ACTION_SEARCH
        binding.svNews.setOnQueryTextListener(object: SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.getListNews(query!!)
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                return false
            }
        })

    }

    companion object{
        @JvmStatic
        fun newInstance() =
            SearchFragment().apply {
                arguments = Bundle().apply {  }
            }
    }
}