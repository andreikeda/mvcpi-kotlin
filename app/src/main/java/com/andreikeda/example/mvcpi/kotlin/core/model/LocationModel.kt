package com.andreikeda.example.mvcpi.kotlin.core.model

import com.google.gson.annotations.SerializedName

data class LocationModel(
    var name: String?,
    var region: String?,
    var country: String?,
    var lat: Double,
    var lng: Double,
    @SerializedName("tz_id") var tzId: String?,
    @SerializedName("local_time") var localtime: String?
)