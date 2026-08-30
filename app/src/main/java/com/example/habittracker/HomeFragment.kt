package com.example.habittracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.habittracker.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // Ortak ViewModel bağlantısı
    private val viewModel: HabitViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvHabits.layoutManager = LinearLayoutManager(requireContext())

        // ViewModel'deki listeyi gözlemliyoruz (Observe)
        viewModel.habitList.observe(viewLifecycleOwner) { habits ->
            // Liste her güncellendiğinde Adapter'a yeni halini verip bağlıyoruz
            val adapter = HabitAdapter(habits)
            binding.rvHabits.adapter = adapter
        }

        // İkinci sayfaya geçiş
        binding.btnAddHabit.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addHabitFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}