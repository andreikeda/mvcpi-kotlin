package com.andreikeda.example.mvcpi.kotlin.core.model

import com.google.gson.annotations.SerializedName

data class CurrentModel(
    @SerializedName("last_update_at") var lastUpdateAt: String?,
    @SerializedName("feels_like_c") var feelsLikeC: Double,
    @SerializedName("feels_like_f") var feelsLikeF: Double,
    @SerializedName("gust_mph") var gustMPH: Double,
    @SerializedName("gust_kph") var gustKPH: Double,
    @SerializedName("temp_c") var tempC: Double,
    @SerializedName("temp_f") var tempF: Double,
    @SerializedName("uv") var uv: Double,
    @SerializedName("wind_mph") var windMPH: Double,
    @SerializedName("wind_kph") var windKPH: Double,
    @SerializedName("humidity") var humidity: Int,
    @SerializedName("wind_degrees") var windDegree: Int,
    @SerializedName("wind_dir") var windDir: Char,
    @SerializedName("is_day") var isDay: Boolean,
    var condition: ConditionModel
)