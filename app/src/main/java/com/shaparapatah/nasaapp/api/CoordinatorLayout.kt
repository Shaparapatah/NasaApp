package com.shaparapatah.nasaapp.api


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shaparapatah.nasaapp.R
import com.shaparapatah.nasaapp.view.picture.CoordinatorFragment

class CoordinatorLayout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coordinator_layout)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CoordinatorFragment.newInstance())
                .commitNow()
        }
    }

}