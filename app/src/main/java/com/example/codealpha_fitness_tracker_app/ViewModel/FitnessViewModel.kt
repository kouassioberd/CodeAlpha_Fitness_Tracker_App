package com.example.codealpha_fitness_tracker_app.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codealpha_fitness_tracker_app.data.local.entity.FitnessEntry
import com.example.codealpha_fitness_tracker_app.data.repository.FitnessRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate

class FitnessViewModel(private val repository: FitnessRepository) : ViewModel() {

    private  val today = LocalDate.now().toString()

    val entries: StateFlow<List<FitnessEntry>> =
        repository.getTodayEntries(today)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())


    fun addEntry(type: String, value: Int) {
        viewModelScope.launch {
            repository.addEntry(
                FitnessEntry(type = type, value = value, date = today)
            )
        }
    }

    val steps: Flow<Int> = entries.map { list ->
        list.filter { it.type == "Steps" }.sumOf { it.value }
    }

    val calories: Flow<Int> = entries.map { list ->
        list.filter { it.type == "Calories" }.sumOf { it.value }
    }

    val workouts: Flow<Int> = entries.map { list ->
        list.filter { it.type == "Workout" }.sumOf { it.value }
    }
}