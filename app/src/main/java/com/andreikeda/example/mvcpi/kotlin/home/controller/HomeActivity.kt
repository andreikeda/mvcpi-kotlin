package com.andreikeda.example.mvcpi.kotlin.home.controller

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.andreikeda.example.mvcpi.kotlin.core.view.LoadingView
import com.andreikeda.example.mvcpi.kotlin.home.presenter.HomePresenter
import com.andreikeda.example.mvcpi.kotlin.home.presenter.HomePresenterToControllerInterface
import com.andreikeda.example.mvcpi.kotlin.home.presenter.HomePresenterToViewInterface
import com.andreikeda.example.mvcpi.kotlin.home.view.HomeView
import com.andreikeda.example.mvcpi.kotlin.home.view.HomeViewToPresenterInterface

interface HomeControllerToPresenterInterface {
    fun onCreate(savedInstanceState: Bundle?)

    fun onStart()

    fun onResume()

    fun onPause()

    fun onRestart()

    fun onDestroy()

    fun setView(view: HomePresenterToViewInterface)
}

class HomeActivity : AppCompatActivity(), HomePresenterToControllerInterface {

    private var presenter: HomeControllerToPresenterInterface? = null

    override fun showCustomView(
        presenter: HomeViewToPresenterInterface?
    ) {
        val view = HomeView(this, presenter)
        setContentView(view as View)
        this.presenter?.setView(view)
    }

    override fun showLoadingView() {
        setContentView(LoadingView(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeVariables()
        presenter?.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        presenter?.onStart()
    }

    override fun onResume() {
        super.onResume()

        presenter?.onResume()
    }

    override fun onPause() {
        super.onPause()

        presenter?.onPause()
    }

    override fun onRestart() {
        super.onRestart()

        presenter?.onRestart()
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        presenter = null

        super.onDestroy()
    }

    private fun initializeVariables() {
        presenter = HomePresenter(this)
    }
}