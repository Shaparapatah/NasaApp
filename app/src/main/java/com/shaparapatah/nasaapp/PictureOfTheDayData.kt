package com.shaparapatah.nasaapp

sealed class PictureOfTheDayData {
        data class Success(val serverResponseData: PODServerResponseData) : PictureOfTheDayData()
        data class Error(val error: Throwable) : PictureOfTheDayData()
        data class Loading(val progress: Int?) : PictureOfTheDayData()
}
