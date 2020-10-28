package com.andreikeda.example.mvcpi.kotlin.core.view

import android.content.Context
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.ProgressBar

class LoadingView(context: Context): LinearLayout(context) {

    init {
        initializeView()
    }

    private fun initializeView() {
        setBackgroundResource(android.R.color.white)
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
        gravity = Gravity.CENTER

        val progressBar = ProgressBar(context)
        progressBar.layoutParams = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
        addView(progressBar)
    }
}