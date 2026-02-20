package com.example.codealpha_fitness_tracker_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.codealpha_fitness_tracker_app.ViewModel.FitnessViewModel
import com.example.codealpha_fitness_tracker_app.ViewModel.FitnessViewModelFactory
import com.example.codealpha_fitness_tracker_app.data.local.dao.FitnessDao
import com.example.codealpha_fitness_tracker_app.data.local.database.AppDatabase
import com.example.codealpha_fitness_tracker_app.data.repository.FitnessRepository
import com.example.codealpha_fitness_tracker_app.ui.screens.FitnessApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "fitness_db"
        ).build()

        val repository = FitnessRepository(db.fitnessDao() as FitnessDao)
        val factory = FitnessViewModelFactory(repository)

        setContent {
            val viewModel: FitnessViewModel = viewModel(factory = factory)
            FitnessApp(viewModel)
        }

    }
}