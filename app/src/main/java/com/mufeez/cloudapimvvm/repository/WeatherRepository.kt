package com.mufeez.cloudapimvvm.repository

import com.mufeez.cloudapimvvm.data.remote.Weather
import com.mufeez.cloudapimvvm.data.remote.WeatherApi
import com.mufeez.cloudapimvvm.utils.Constants.API_KEY
import com.mufeez.cloudapimvvm.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class WeatherRepository @Inject constructor(
    private val api: WeatherApi
) {
    suspend fun getWeatherInfo(
        lat: String,
        lon: String
    ): Resource<Weather> {
        val response = try {
            api.getWeather(lat, lon, API_KEY)
        } catch (e: Exception) {
            return Resource.Error("Unknown Error occurred.")
        }
        return Resource.Success(response)
    }
}