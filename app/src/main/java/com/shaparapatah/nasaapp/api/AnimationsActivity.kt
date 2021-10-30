package com.shaparapatah.nasaapp.api

import android.os.Bundle
import android.transition.Slide
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.transition.TransitionManager
import android.view.Gravity
import com.shaparapatah.nasaapp.R
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationsActivity : AppCompatActivity() {

    private var textIsVisible = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        button.setOnClickListener {
            TransitionManager.beginDelayedTransition(transitions_container, Slide(Gravity.END))
            textIsVisible = !textIsVisible
            text.visibility = if (textIsVisible) View.VISIBLE else View.GONE
        }
    }
}