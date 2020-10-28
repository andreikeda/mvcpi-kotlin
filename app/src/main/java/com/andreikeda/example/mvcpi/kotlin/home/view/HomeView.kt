package com.andreikeda.example.mvcpi.kotlin.home.view

import android.content.Context
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import com.andreikeda.example.mvcpi.kotlin.core.model.ConditionModel
import com.andreikeda.example.mvcpi.kotlin.home.presenter.HomePresenterToViewInterface

interface HomeViewToPresenterInterface

class HomeView(
    context: Context,
    private val presenter: HomeViewToPresenterInterface?
) : LinearLayout(context), HomePresenterToViewInterface {

    private var tvCondition: TextView? = null
    private var tvLocationName: TextView? = null
    private var tvLocationRegion: TextView? = null
    private var tvTemperature: TextView? = null
    private var tvUV: TextView? = null

    override fun initialize() {
        orientation = VERTICAL
    }

    override fun setCondition(condition: ConditionModel?) {
        tvCondition = TextView(context)
        tvCondition?.apply {
            layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
            )
            text = condition?.text
            gravity = Gravity.CENTER
        }
        addView(tvCondition)
    }

    override fun setLocationName(name: String?) {
        tvLocationName = TextView(context)
        tvLocationName?.apply {
            layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
            )
            text = name
            gravity = Gravity.CENTER
        }
        addView(tvLocationName)
    }

    override fun setLocationRegion(region: String?) {
        tvLocationRegion = TextView(context)
        tvLocationRegion?.apply {
            layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
            )
            text = region
            gravity = Gravity.CENTER
        }
        addView(tvLocationRegion)
    }

    override fun setTemperature(temperature: String?) {
        tvTemperature = TextView(context)
        tvTemperature?.apply {
            layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
            )
            text = String.format("%s ˚C", temperature)
            gravity = Gravity.CENTER
        }
        addView(tvTemperature)
    }

    override fun setUV(uv: String?) {
        tvUV = TextView(context)
        tvUV?.apply {
            layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
            )
            text = String.format("UV: %s", uv)
            gravity = Gravity.CENTER
        }
        addView(tvUV)
    }
}
