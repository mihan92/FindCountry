package com.example.findcountry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.findcountry.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSearch.setOnClickListener {
            val cityName = binding.editTextSearch.text.toString()

            lifecycleScope.launch {

                try {
                    val countries = restCountriesService.getCountryByName(cityName)
                    val country = countries[0]
                    binding.textViewCountryName.text = country.name
                    binding.textViewCapital.text = country.capital
                    binding.textViewPopulation.text = formatNumber(country.population)
                    binding.textViewLanguages.text = languagesToString(country.languages)
                    getImage(binding.imageViewFlag, country.flag)
                    binding.showDetails.visibility = View.VISIBLE

                } catch (e: Exception){
                    Toast.makeText(this@MainActivity, "Такая страна не найдена", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



}