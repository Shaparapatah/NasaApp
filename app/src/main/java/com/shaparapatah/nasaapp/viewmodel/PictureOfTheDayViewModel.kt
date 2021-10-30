package com.shaparapatah.nasaapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shaparapatah.nasaapp.BuildConfig
import com.shaparapatah.nasaapp.repository.PODRetrofitImpl
import com.shaparapatah.nasaapp.repository.PODServerResponseData
import com.shaparapatah.nasaapp.repository.SolarFlareResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureOfTheDayViewModel(
    private val liveDataForViewToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val retrofitImpl: PODRetrofitImpl = PODRetrofitImpl()
) :
    ViewModel() {

    fun getData(): LiveData<AppState> {
        sendServerRequest()
        return liveDataForViewToObserve
    }

    private fun sendServerRequest() {
        liveDataForViewToObserve.value = AppState.Loading(null)
        val apiKey: String = BuildConfig.NASA_API_KEY
        if (apiKey.isBlank()) {
            AppState.Error(Throwable("You need API key"))
        } else {
            retrofitImpl.getPictureOfTheDay(apiKey, PODCallBack)
            retrofitImpl.getSolarFlareToday(apiKey, SolarFlareCallBack, "2021-09-01")
        }
    }

    val PODCallBack = object :
        Callback<PODServerResponseData> {
        override fun onResponse(
            call: Call<PODServerResponseData>,
            response: Response<PODServerResponseData>
        ) {
            if (response.isSuccessful && response.body() != null) {
                liveDataForViewToObserve.value =
                    AppState.Success(response.body() as PODServerResponseData)
            } else {
                val message = response.message()
                if (message.isNullOrEmpty()) {
                    liveDataForViewToObserve.value =
                        AppState.Error(Throwable("Unidentified error"))
                } else {
                    liveDataForViewToObserve.value =
                        AppState.Error(Throwable(message))
                }
            }
        }

        override fun onFailure(call: Call<PODServerResponseData>, t: Throwable) {
            liveDataForViewToObserve.value = AppState.Error(t)
        }
    }

    val SolarFlareCallBack = object :
        Callback<List<SolarFlareResponseData>> {
        override fun onResponse(
            call: Call<List<SolarFlareResponseData>>,
            response: Response<List<SolarFlareResponseData>>
        ) {
            if (response.isSuccessful && response.body() != null) {

            } else {
                val message = response.message()
                if (message.isNullOrEmpty()) {
                    liveDataForViewToObserve.value =
                        AppState.Error(Throwable("Unidentified error"))
                } else {
                    liveDataForViewToObserve.value =
                        AppState.Error(Throwable(message))
                }
            }
        }

        override fun onFailure(call: Call<List<SolarFlareResponseData>>, t: Throwable) {
            liveDataForViewToObserve.value = AppState.Error(t)
        }
    }
}