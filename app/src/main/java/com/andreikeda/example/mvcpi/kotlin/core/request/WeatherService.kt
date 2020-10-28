package com.andreikeda.example.mvcpi.kotlin.core.request

import com.andreikeda.example.mvcpi.kotlin.core.model.response.GetCurrentWeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("current.json")
    fun getCurrentWeather(@Query("key") key: String, @Query("q") q: String): Call<GetCurrentWeatherResponse>
}