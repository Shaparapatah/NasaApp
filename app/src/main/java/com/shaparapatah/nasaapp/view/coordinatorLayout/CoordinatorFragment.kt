package com.shaparapatah.nasaapp.view.coordinatorLayout

/*
class CoordinatorFragment : Fragment() {

    private val viewModel: PictureOfTheDayViewModel by lazy {
        ViewModelProviders.of(this).get(PictureOfTheDayViewModel::class.java)
    }

    companion object {
        fun newInstance() = CoordinatorFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getData()
            .observe(viewLifecycleOwner, Observer<AppState> { renderData(it) })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.coordinator_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun renderData(data: AppState) {
        when (data) {
            is AppState.Success -> {

                val serverResponseData = data.serverResponseData
                val url = serverResponseData.url
                if (url.isNullOrEmpty()) {
                    toast("Link is empty")
                } else {
                    image_view.load(url) {
                        lifecycle(this@CoordinatorFragment)
                        error(R.drawable.ic_load_error_vector)
                        placeholder(R.drawable.ic_no_photo_vector)
                    }
                }
                loadingLayout.visibility = View.INVISIBLE
                main.visibility = View.VISIBLE

            }
            is AppState.Loading -> {
                loadingLayout.visibility = View.VISIBLE
                main.visibility = View.INVISIBLE

            }
            is AppState.Error -> {
                toast(data.error.message)
            }
        }
    }

    private fun Fragment.toast(string: String?) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.BOTTOM, 0, 250)
            show()
        }
    }

}

 */