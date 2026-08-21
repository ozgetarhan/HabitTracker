package com.example.habittracker

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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
                val alert = AlertDialog.Builder(this)
                alert.setTitle("Kayıt Et")
                alert.setMessage("Kayıt etmek istediğinize emin misiniz?")

                alert.setPositiveButton("Evet") { dialog, which ->
                    Toast.makeText(this, "Kayıt edildi", Toast.LENGTH_LONG).show()

                    // "Evet" denilince Intent ile MainActivity'ye dön
                    val intent = Intent(this@AddHabitActivity, MainActivity::class.java)
                    intent.putExtra("HABIT_NAME", habitName)
                    startActivity(intent)
                    finish()
                }

                alert.setNegativeButton("Hayır") { dialog, which ->
                    Toast.makeText(this, "Kayıt iptal edildi", Toast.LENGTH_LONG).show()
                }

                // Dialogu ekranda göstermek için:
                alert.show()}
            else{
                Toast.makeText(this, "Lütfen bir alışkanlık girin!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}