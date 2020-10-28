package com.andreikeda.example.mvcpi.kotlin.home.interactor

import com.andreikeda.example.mvcpi.kotlin.BuildConfig
import com.andreikeda.example.mvcpi.kotlin.core.facade.HomeFacade
import com.andreikeda.example.mvcpi.kotlin.core.model.response.GetCurrentWeatherResponse
import com.andreikeda.example.mvcpi.kotlin.core.request.WeatherService
import com.andreikeda.example.mvcpi.kotlin.home.presenter.HomePresenterToInteractorInterface
import com.google.gson.GsonBuilder
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface HomeInteractorToPresenterInterface {
    fun onFailure(stacktrace: Throwable)

    fun onResponseSuccess(response: GetCurrentWeatherResponse)

    fun onResponseError(error: ResponseBody)
}

class HomeInteractor(
    private val presenter: HomeInteractorToPresenterInterface?
) : HomePresenterToInteractorInterface {
    private val service: WeatherService

    init {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        service = retrofit.create(WeatherService::class.java)
    }

    override fun currentWeather(facade: HomeFacade) {
        val cb = object : Callback<GetCurrentWeatherResponse> {
            override fun onResponse(
                call: Call<GetCurrentWeatherResponse>,
                response: Response<GetCurrentWeatherResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { presenter?.onResponseSuccess(it) }
                } else {
                    response.errorBody()?.let { presenter?.onResponseError(it) }
                }
            }

            override fun onFailure(call: Call<GetCurrentWeatherResponse>, t: Throwable) {
                presenter?.onFailure(t)
            }
        }
        service.getCurrentWeather(
            BuildConfig.API_KEY,
            facade.coordinates
        ).enqueue(cb)
    }
}