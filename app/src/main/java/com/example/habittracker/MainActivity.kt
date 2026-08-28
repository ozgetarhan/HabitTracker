package com.example.habittracker

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.habittracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Lİste tanımla
    companion object {
        val habitList = arrayListOf<Habit>()
    }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //İkinci sayfadan gelen veriyi kontrol et ve listeye ekle
        val incomingHabit = intent.getStringExtra("HABIT_NAME")
        if (!incomingHabit.isNullOrEmpty()) {
            habitList.add(Habit(incomingHabit, false))
        }

        //Adapter ve LayoutManager bağlantısını yap
        binding.rvHabits.layoutManager = LinearLayoutManager(this)
        val adapter = HabitAdapter(habitList)
        binding.rvHabits.adapter = adapter

        //İkinci sayfaya geçiş butonu
        binding.btnAddHabit.setOnClickListener {
            val intent = Intent(this@MainActivity, AddHabitActivity::class.java)
            startActivity(intent)
        }
    }
}