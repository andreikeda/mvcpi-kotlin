package com.andreikeda.example.mvcpi.kotlin.core.model.request

data class GetCurrentCoordinatesRequest(
    var lat: Double,
    var lng: Double
) {
    override fun toString(): String {
        return "$lat,$lng"
    }
}