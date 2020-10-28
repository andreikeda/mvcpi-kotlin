package com.andreikeda.example.mvcpi.kotlin.core.model.response

import com.andreikeda.example.mvcpi.kotlin.core.model.CurrentModel
import com.andreikeda.example.mvcpi.kotlin.core.model.LocationModel

data class GetCurrentWeatherResponse(
    var current: CurrentModel,
    var location: LocationModel
)