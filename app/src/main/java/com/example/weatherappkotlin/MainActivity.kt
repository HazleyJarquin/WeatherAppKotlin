package com.example.weatherappkotlin

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.weatherappkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.weatherData.observe(this, Observer { weather ->
            weather?.let {
                binding.temperatureTextView.text = "${it.main.temp}°C"
                binding.descriptionTextView.text = it.weather[0].description
                binding.cityNameTextView.text = it.name
            }
        })

        binding.searchButton.setOnClickListener {
            val city = binding.cityEditText.text.toString()
            viewModel.fetchWeather(city, "b37458401b415a652387e52d4883efb4")
        }
    }
}