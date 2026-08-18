package com.example.habittracker

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.habittracker.databinding.ActivityAddHabitBinding

class AddHabitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddHabitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddHabitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val habitName = binding.etHabitName.text.toString().trim()
            if (habitName.isNotEmpty()) {
                val intent = Intent(this@AddHabitActivity, MainActivity::class.java)
                intent.putExtra("HABIT_NAME", habitName)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "Lütfen bir alışkanlık girin!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}