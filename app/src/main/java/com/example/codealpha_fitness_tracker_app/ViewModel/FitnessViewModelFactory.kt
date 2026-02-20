package com.example.codealpha_fitness_tracker_app.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.codealpha_fitness_tracker_app.data.repository.FitnessRepository

class FitnessViewModelFactory(
    private val repository: FitnessRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FitnessViewModel(repository) as T
    }
}