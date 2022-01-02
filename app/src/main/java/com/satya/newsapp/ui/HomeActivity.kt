package com.satya.newsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.satya.newsapp.R
import com.satya.newsapp.databinding.ActivityHomeBinding
import com.satya.newsapp.ui.fragment.bottomnavigation.home.NewsFragment
import com.satya.newsapp.ui.dashboard.DashboardFragment
import com.satya.newsapp.ui.fragment.bottomnavigation.search.SearchFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        supportActionBar?.hide()

        replaceFragment(NewsFragment.newInstance())
        homeBinding.navView.show(0)
        homeBinding.navView.add(MeowBottomNavigation.Model(0, R.drawable.ic_outline_article_24))
        homeBinding.navView.add(MeowBottomNavigation.Model(1, R.drawable.ic_baseline_search_24))
        homeBinding.navView.add(MeowBottomNavigation.Model(2,
            R.drawable.ic_outline_bookmark_border_24
        ))

        homeBinding.navView.setOnClickMenuListener{
            when(it.id){
                0 -> {
                    replaceFragment(NewsFragment.newInstance())
                }
                1 -> {
                    replaceFragment(SearchFragment.newInstance())
                }
                2 -> {
                    replaceFragment(DashboardFragment.newInstance())
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.nav_host_fragment, fragment)
        fragmentTransition.commit()
    }
}