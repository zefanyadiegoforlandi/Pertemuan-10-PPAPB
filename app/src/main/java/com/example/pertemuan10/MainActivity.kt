package com.example.pertemuan10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pertemuan10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterRestaurant = RestaurantAdapter(generateRestaurant()) {
            restaurant -> Toast.makeText(this@MainActivity, "Hei! You clicked on ${restaurant.name}",
            Toast.LENGTH_SHORT).show()
        }
        with(binding) {
            rvRestaurant.apply {
                adapter = adapterRestaurant
                layoutManager = GridLayoutManager(this@MainActivity,2)
            }
        }
    }
    fun generateRestaurant() : List<Restaurant> {
        return listOf(
            Restaurant(name="Mcdonalds", type = "Western"),
            Restaurant(name="Mas Bong Steak", type = "Western"),
            Restaurant(name="Sushi Tei", type = "Japanese"),
            Restaurant(name="Sabana Murah 3", type = "Minang"),
            Restaurant(name="Orion", type = "Chinese")
        )
    }
}