package com.shaparapatah.nasaapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shaparapatah.nasaapp.R
import com.shaparapatah.nasaapp.databinding.ActivityMainBinding
import com.shaparapatah.nasaapp.databinding.FragmentMainBinding
import com.shaparapatah.nasaapp.view.picture.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_NasaApp)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance()).commit()
        }
    }
}
