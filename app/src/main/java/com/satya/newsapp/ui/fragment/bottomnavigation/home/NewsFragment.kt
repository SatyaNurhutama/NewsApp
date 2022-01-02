package com.satya.newsapp.ui.fragment.bottomnavigation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import com.google.android.material.tabs.TabLayoutMediator
import com.satya.newsapp.R
import com.satya.newsapp.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding

    companion object{
        @JvmStatic
        fun newInstance() =
            NewsFragment().apply {
                arguments = Bundle().apply {  }
            }


        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.all_news,
            R.string.bisnis,
            R.string.kesehatan,
            R.string.entertaiment,
            R.string.teknologi,
            R.string.ilmu
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sectionPagerAdapter = SectionPagerAdapter(this)
        binding.viewPager.adapter = sectionPagerAdapter
        binding.viewPager.isUserInputEnabled = false
        TabLayoutMediator(binding.tabs, binding.viewPager){ tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

    }


}