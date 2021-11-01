package com.shaparapatah.nasaapp.view.recyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shaparapatah.nasaapp.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {

    lateinit var binding: ActivityRecyclerBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val data = listOf(
            Data("Earth"),
            Data("Mars", ""),
            Data("Mars", ""),
            Data("Mars", ""),
            Data("Earth"),
            Data("Earth"),
            Data("Earth"),
            Data("Mars", "")
        )
        binding.recyclerView.adapter = RecyclerActivityAdapter(
            object : OnListItemClickListener {
                override fun onItemClick(data: Data) {
                    Toast.makeText(this@RecyclerActivity, data.someText, Toast.LENGTH_SHORT).show()
                }

            }, data
        )

    }
}