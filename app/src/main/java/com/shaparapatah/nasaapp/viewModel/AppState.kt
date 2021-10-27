package com.shaparapatah.nasaapp.viewModel

import com.shaparapatah.nasaapp.repository.PODServerResponseData
import com.shaparapatah.nasaapp.repository.SolarFlareResponseData

sealed class AppState {
        data class Success(val serverResponseData: PODServerResponseData) : AppState()
        data class SuccessSolar(val serverResponseData: SolarFlareResponseData) : AppState()
        data class Error(val error: Throwable) : AppState()
        data class Loading(val progress: Int?) : AppState()
}
