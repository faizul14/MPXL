package com.faezolfp.miniprojekxl.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("schedule/web")
    fun getSchedule(
        @Query("date") date: String,
        @Query("country") country: String
    ): Call<List<ResponseApiItem>>
}