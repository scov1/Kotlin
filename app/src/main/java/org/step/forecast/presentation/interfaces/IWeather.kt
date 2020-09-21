package org.step.forecast.presentation.interfaces

import io.reactivex.Observable
import org.step.forecast.data.model.WeatherResult
import retrofit2.http.GET
import retrofit2.http.Query

interface IWeather {
    @GET("weather")
    fun getWeatherLatLon(
        @Query("lat") lat: String?,
        @Query("lon") lon: String?,
        @Query("appid") appid: String?,
        @Query("units") unit: String?
    ): Observable<WeatherResult?>?
}