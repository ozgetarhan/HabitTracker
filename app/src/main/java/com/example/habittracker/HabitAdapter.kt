package com.example.habittracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker.databinding.ActivityMainBinding
import com.example.habittracker.databinding.ItemRowBinding

class HabitAdapter(val habitList: List<Habit>): RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HabitViewHolder {
        //ViewHolder objesi oluşturmak için.
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HabitViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: HabitViewHolder,
        position: Int
    ) {
        //ViewHolder elemanları ile etkileşime girildiğinde yapılacak işlemleri belirtmek için.
        val currentHabit = habitList[position]
        holder.binding.twHabitRowTitle.text = currentHabit.title
        holder.binding.cbHabitDone.isChecked = currentHabit.isCompleted
        holder.binding.cbHabitDone.setOnCheckedChangeListener { _, isChecked ->
            currentHabit.isCompleted = isChecked
        }
    }

    override fun getItemCount(): Int {
        //Row elemenından kaç tane oluşturulacağını belirtmek için.
        return habitList.size
    }

    class HabitViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root){
    }
}