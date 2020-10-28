package com.andreikeda.example.mvcpi.kotlin.home.presenter

import android.os.Bundle
import com.andreikeda.example.mvcpi.kotlin.BuildConfig
import com.andreikeda.example.mvcpi.kotlin.core.facade.HomeFacade
import com.andreikeda.example.mvcpi.kotlin.core.model.ConditionModel
import com.andreikeda.example.mvcpi.kotlin.core.model.response.GetCurrentWeatherResponse
import com.andreikeda.example.mvcpi.kotlin.home.controller.HomeControllerToPresenterInterface
import com.andreikeda.example.mvcpi.kotlin.home.interactor.HomeInteractor
import com.andreikeda.example.mvcpi.kotlin.home.interactor.HomeInteractorToPresenterInterface
import com.andreikeda.example.mvcpi.kotlin.home.view.HomeViewToPresenterInterface
import okhttp3.ResponseBody

interface HomePresenterToControllerInterface {
    fun showCustomView(
        presenter: HomeViewToPresenterInterface?
    )

    fun showLoadingView()
}

interface HomePresenterToInteractorInterface {
    fun currentWeather(facade: HomeFacade)
}

interface HomePresenterToViewInterface {
    fun initialize()

    fun setCondition(condition: ConditionModel?)

    fun setLocationName(name: String?)

    fun setLocationRegion(region: String?)

    fun setTemperature(temperature: String?)

    fun setUV(uv: String?)
}

class HomePresenter(
    private val controller: HomePresenterToControllerInterface?
) : HomeInteractorToPresenterInterface, HomeControllerToPresenterInterface,
    HomeViewToPresenterInterface {

    private val interactor: HomePresenterToInteractorInterface?
    private var view: HomePresenterToViewInterface? = null
    private val facade: HomeFacade

    init {
        interactor = HomeInteractor(this)
        facade = HomeFacade(
            BuildConfig.LAT,
            BuildConfig.LNG
        )
    }

    override fun onFailure(stacktrace: Throwable) {

    }

    override fun onResponseSuccess(response: GetCurrentWeatherResponse) {
        controller?.showCustomView(this)
        view?.apply {
            initialize()
            setLocationName(response.location.name)
            setLocationRegion(response.location.region)
            setTemperature(response.current.tempC.toString())
            setUV(response.current.uv.toString())
            setCondition(response.current.condition)
        }
    }

    override fun onResponseError(error: ResponseBody) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        controller?.showLoadingView()
    }

    override fun onStart() {
        interactor?.currentWeather(facade)
    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onRestart() {

    }

    override fun onDestroy() {

    }

    override fun setView(view: HomePresenterToViewInterface) {
        this.view = view
    }
}
