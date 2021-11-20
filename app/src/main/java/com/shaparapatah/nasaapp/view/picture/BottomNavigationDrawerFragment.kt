package com.shaparapatah.nasaapp.view.picture

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.shaparapatah.nasaapp.R
import com.shaparapatah.nasaapp.view.animations.AnimationFAB
import com.shaparapatah.nasaapp.view.animations.AnimationsActivityBonus
import com.shaparapatah.nasaapp.view.recyclerView.RecyclerActivity
import kotlinx.android.synthetic.main.bottom_navigation_layout.*

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_navigation_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_one -> activity?.let {
                    startActivity(
                        Intent(
                            it,
                            AnimationsActivityBonus::class.java
                        )
                    )
                }
                R.id.navigation_two -> activity?.let {
                    startActivity(
                        Intent(
                            it,
                            AnimationFAB::class.java
                        )
                    )
                }
                R.id.navigation_three -> activity?.let {
                    startActivity(
                        Intent(
                            it,
                            RecyclerActivity::class.java
                        )
                    )
                }
            }
            true
        }
    }

    companion object {
        fun newInstance() = BottomNavigationDrawerFragment()
    }
}

