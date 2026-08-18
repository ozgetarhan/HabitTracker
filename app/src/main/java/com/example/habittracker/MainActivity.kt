package com.example.habittracker

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.habittracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
            val incomingHabit = intent.getStringExtra("HABIT_NAME")
        if (!incomingHabit.isNullOrEmpty()) {
            binding.tvHabitDisplay.text = "Günün Hedefi:\n$incomingHabit"
        }

        binding.btnAddHabit.setOnClickListener {
            val intent = Intent(this@MainActivity, AddHabitActivity::class.java)
            startActivity(intent)
        }
    }
}