package com.satya.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.google.android.material.tabs.TabLayoutMediator
import com.satya.newsapp.databinding.ActivityMainBinding
import com.satya.newsapp.fragment.news.SectionPagerAdapter

class MainActivity : AppCompatActivity() {

    /* private lateinit var mainBinding: ActivityMainBinding

    //private var newsAdapter: NewsAdapter? = null

    companion object{
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val sectionPagerAdapter = SectionPagerAdapter(this)
        mainBinding.viewPager.adapter = sectionPagerAdapter
        mainBinding.viewPager.isUserInputEnabled = false
        TabLayoutMediator(mainBinding.tabs, mainBinding.viewPager){ tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f


        /*
        viewModel.getListNews()

        mainBinding.rvItem.layoutManager = LinearLayoutManager(this)
        mainBinding.rvItem2.layoutManager = LinearLayoutManager(this)
        mainBinding.rvItem.setHasFixedSize(true)
        mainBinding.rvItem2.setHasFixedSize(true)

        getNews()

         */
    }


    /*
    private fun getNews(){
        viewModel.listNews.observe(this,  { news ->

            newsAdapter = news?.let { NewsAdapter(this, news) }
            mainBinding.rvItem.adapter = newsAdapter

            mainBinding.svNews.imeOptions = EditorInfo.IME_ACTION_SEARCH
            mainBinding.svNews.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean = false

                override fun onQueryTextChange(action: String?): Boolean {
                    if (action != null){
                       if(action.isEmpty()){
                           mainBinding.rvItem.visibility = View.VISIBLE
                           mainBinding.rvItem2.visibility = View.GONE
                           mainBinding.tvNull.visibility = View.GONE

                       } else if (action.length > 2){
                           val filter = news.filter { it.title.contains("$action", true) }
                           newsAdapter = NewsAdapter(this@MainActivity, filter as ArrayList<ArticlesItem>)

                           if(action.isNotEmpty()){

                               if (filter.isEmpty()){
                                   mainBinding.tvNull.visibility = View.VISIBLE
                                   mainBinding.rvItem.visibility = View.INVISIBLE
                                   mainBinding.rvItem2.visibility = View.VISIBLE
                               } else{
                                   mainBinding.tvNull.visibility = View.GONE
                               }

                               mainBinding.rvItem.visibility = View.INVISIBLE
                               mainBinding.rvItem2.visibility = View.VISIBLE
                               mainBinding.rvItem2.adapter = newsAdapter
                           } else {
                               mainBinding.rvItem.visibility = View.VISIBLE
                               mainBinding.rvItem2.visibility = View.GONE
                           }

                       }
                    }
                    return false
                }
            })
        })
    }

     */

     */

}