package com.shaparapatah.nasaapp.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {
    @GET("planetary/apod")
    fun getPictureOfTheDay(@Query("api_key") apiKey: String): Call<PODServerResponseData>

    @GET("DONKI/FLR")
    fun getSolarFlare(
        @Query("api_key") apiKey: String,
        @Query("startDate") startDate: String = "2021-10-01",
        @Query("endDate") endDate: String = "2021-10-24"
    ): Call<List<SolarFlareResponseData>>


    @GET("DONKI/FLR")
    fun getSolarFlareToday(
        @Query("api_key") apiKey: String,
        @Query("startDate") startDate: String = "2021-09-07",
    ): Call<List<SolarFlareResponseData>>

}