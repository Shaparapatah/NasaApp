package com.shaparapatah.nasaapp.view.picture

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.ChangeImageTransform
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import coil.load
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.shaparapatah.nasaapp.MainActivity
import com.shaparapatah.nasaapp.R
import com.shaparapatah.nasaapp.api.ApiActivity
import com.shaparapatah.nasaapp.api.ApiBottomActivity
import com.shaparapatah.nasaapp.api.CoordinatorLayout
import com.shaparapatah.nasaapp.databinding.FragmentMainBinding
import com.shaparapatah.nasaapp.viewmodel.AppState
import com.shaparapatah.nasaapp.viewmodel.PictureOfTheDayViewModel
import kotlinx.android.synthetic.main.activity_animations_enlarge.*
import kotlinx.android.synthetic.main.fragment_chips.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.image_view
import kotlinx.android.synthetic.main.fragment_main_explanation_text.*


class PictureOfTheDayFragment : Fragment() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    private var _binding: FragmentMainBinding? = null
    val binding: FragmentMainBinding
        get() {
            return _binding!!
        }

    private val viewModel: PictureOfTheDayViewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentMainBinding.inflate(inflater)
        setActionBar()

        return binding.root
    }

    private var isMain = true
    private fun setActionBar() {
        (context as MainActivity).setSupportActionBar(binding.bottomAppBar)
        setHasOptionsMenu(true)
        binding.fab.setOnClickListener {
            if (isMain) {
                isMain = false
                binding.bottomAppBar.navigationIcon = null // лучше придумать замену бургеру
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                binding.fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_back_fab
                    )
                )
                binding.bottomAppBar.replaceMenu(R.menu.menu_bottom_bar_other_screen)
            } else {
                isMain = true
                binding.bottomAppBar.navigationIcon =
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_hamburger_menu_bottom_bar
                    )
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                binding.fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_plus_fab
                    )
                )
                binding.bottomAppBar.replaceMenu(R.menu.menu_bottom_bar)
            }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.sendServerRequest()

        binding.inputLayout.setEndIconOnClickListener {
            val i = Intent(Intent.ACTION_VIEW).apply {
                data =
                    Uri.parse("https://en.wikipedia.org/wiki/${binding.inputEditText.text.toString()}")
            }
            startActivity(i)
        }
        bottomSheetBehavior = BottomSheetBehavior.from(binding.includeLayout.bottomSheetContainer)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN


    }

    private fun renderData(data: AppState) {
        when (data) {
            is AppState.Error -> {
                Toast.makeText(context, "AppState error", Toast.LENGTH_LONG).show()
            }
            is AppState.Loading -> {

            }
            is AppState.Success -> {
                binding.imageView.load(data.serverResponseData.url) {
                    error(R.drawable.ic_load_error_vector)
                }
                data.serverResponseData.explanation?.let {
                    binding.includeLayoutTv.textViewForFonts.text = it
                }
                binding.includeLayoutTv.textViewForFonts.typeface =
                    Typeface.createFromAsset(requireContext().assets, "LongFox-o77A.ttf")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() = PictureOfTheDayFragment()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.app_bar_fav -> {
                Toast.makeText(context, "Favorite", Toast.LENGTH_SHORT).show()
                startActivity(Intent(context, ApiActivity::class.java))
            }

            R.id.app_bar_change_style -> {
                Toast.makeText(context, "Favorite", Toast.LENGTH_SHORT).show()
                startActivity(Intent(context, ApiBottomActivity::class.java))
            }
            R.id.app_bar_coordinator_layout -> {
                startActivity(Intent(context, CoordinatorLayout::class.java))
            }

            android.R.id.home -> {
                BottomNavigationDrawerFragment.newInstance()
                    .show(requireActivity().supportFragmentManager, "")
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
