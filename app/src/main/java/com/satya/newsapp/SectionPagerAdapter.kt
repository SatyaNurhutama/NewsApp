package com.satya.newsapp

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.satya.newsapp.fragment.business.BusinessFragment
import com.satya.newsapp.fragment.entertainment.EntertainmentFragment
import com.satya.newsapp.fragment.health.HealthFragment
import com.satya.newsapp.fragment.home.HomeFragment
import com.satya.newsapp.fragment.science.ScienceFragment
import com.satya.newsapp.fragment.technology.TechnologyFragment


class SectionPagerAdapter(private val activity: AppCompatActivity) : FragmentStateAdapter(activity) {

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