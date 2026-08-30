package com.example.habittracker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HabitViewModel : ViewModel() {

    // 1. Sadece ViewModel içinden değiştirilebilen liste (Korumalı Kasa)
    private val _habitList = MutableLiveData<ArrayList<Habit>>(arrayListOf())

    // 2. Fragment'ların dışarıdan sadece okuyabileceği güvenli liste
    val habitList: LiveData<ArrayList<Habit>> = _habitList

    // 3. Yeni alışkanlık ekleme fonksiyonu
    fun addHabit(title: String) {
        val currentList = _habitList.value ?: arrayListOf()
        currentList.add(Habit(title, false))

        // Listeyi güncellediğimizi dinleyenlere haber veriyoruz:
        _habitList.value = currentList
    }
}