package com.shaparapatah.nasaapp.api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shaparapatah.nasaapp.R
import kotlinx.android.synthetic.main.api_activity.*

class ApiActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.api_activity)
        view_pager.adapter = ViewPagerAdapter(supportFragmentManager)
        tab_layout.setupWithViewPager(view_pager)
        tab_layout.getTabAt(0)?.setIcon(R.drawable.ic_earth)
        tab_layout.getTabAt(1)?.setIcon(R.drawable.ic_mars)
        tab_layout.getTabAt(2)?.setIcon(R.drawable.ic_weather)
    }
}
