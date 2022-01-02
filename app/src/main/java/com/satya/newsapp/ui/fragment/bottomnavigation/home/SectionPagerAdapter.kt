package com.satya.newsapp.ui.fragment.bottomnavigation.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.satya.newsapp.ui.fragment.business.BusinessFragment
import com.satya.newsapp.ui.fragment.entertainment.EntertainmentFragment
import com.satya.newsapp.ui.fragment.health.HealthFragment
import com.satya.newsapp.ui.fragment.allnews.HomeFragment
import com.satya.newsapp.ui.fragment.science.ScienceFragment
import com.satya.newsapp.ui.fragment.technology.TechnologyFragment

class SectionPagerAdapter(private val fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = HomeFragment()
            1 -> fragment = BusinessFragment()
            2 -> fragment = HealthFragment()
            3 -> fragment = EntertainmentFragment()
            4 -> fragment = TechnologyFragment()
            5 -> fragment = ScienceFragment()
            else -> Fragment()
        }
        return fragment as Fragment
    }
}