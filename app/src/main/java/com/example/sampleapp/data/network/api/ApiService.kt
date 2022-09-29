package com.example.sampleapp.data.network.api

import com.example.sampleapp.data.network.responses.SearchResponseItem
import com.example.sampleapp.data.network.responses.WeatherResponse
import com.example.sampleapp.data.network.responses.WeatherResponseByDays
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("current.json?")
    suspend fun getCityWeather(
        @Query("q") cityName: String,
    ): Response<WeatherResponse>

    @GET("forecast.json?")
    suspend fun getCityWeatherByDays(
        @Query("q") cityName: String,
        @Query("days") days: String,
    ): Response<WeatherResponseByDays>

    @GET("search.json?")
    suspend fun search(
        @Query("q") name: String,
    ): Response<List<SearchResponseItem>>
}