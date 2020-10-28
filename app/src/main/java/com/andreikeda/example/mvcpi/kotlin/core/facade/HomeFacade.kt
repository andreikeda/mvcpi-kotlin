package com.andreikeda.example.mvcpi.kotlin.core.facade

class HomeFacade(
    private var lat: String?,
    private var lng: String?
) {

    val coordinates: String
        get() = "$lat,$lng"

}