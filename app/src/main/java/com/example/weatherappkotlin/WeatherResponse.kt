package com.example.weatherappkotlin

data class WeatherResponse (
    val main: Main,
    val weather: List<Weather>,
    val name: String
)

data class Main(
    val temp: Float,
    val humidity: Int
)

data class Weather (
    val description: String
)