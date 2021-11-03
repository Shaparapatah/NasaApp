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

        val data = arrayListOf(
            Data("Mars", "")
        )
        data.add(0, Data("Header"))
        val adapter = RecyclerActivityAdapter(
            object : OnListItemClickListener {
                override fun onItemClick(data: Data) {
                    Toast.makeText(this@RecyclerActivity, data.someText, Toast.LENGTH_SHORT).show()
                }

            }, data
        )
        binding.recyclerView.adapter = adapter
        binding.recyclerActivityFAB.setOnClickListener { adapter.appendItem() }

    }
}