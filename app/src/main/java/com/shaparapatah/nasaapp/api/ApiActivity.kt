package com.shaparapatah.nasaapp.api

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shaparapatah.nasaapp.R

class ApiActivity : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.api_activity, container, false)
    }

    companion object {
        fun newInstance() = ApiActivity()
    }
}