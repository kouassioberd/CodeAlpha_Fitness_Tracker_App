package com.example.codealpha_fitness_tracker_app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codealpha_fitness_tracker_app.ViewModel.FitnessViewModel

@Composable
fun DashboardScreen(viewModel: FitnessViewModel, padding: PaddingValues) {

    val steps by viewModel.steps.collectAsState(initial = 0)
    val calories by viewModel.steps.collectAsState(initial = 0)
    val workouts by viewModel.steps.collectAsState(initial = 0)

    Column(
        modifier = Modifier
            .padding(padding)
            .padding(16.dp)
    ) {

        Text("Today's Progress", style = MaterialTheme.typography.headlineSmall)

        Spacer(Modifier.height(16.dp))

        ProgressItem("Steps", steps, goal = 10000)
        ProgressItem("Calories", calories, goal = 2000)
        ProgressItem("Workout (min)", workouts, goal = 60)
    }
}

@Composable
fun ProgressItem(label: String, value: Int, goal: Int){

    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
    ) {
        Text("$label: $value / $goal")

        LinearProgressIndicator(
            progress = (value.toFloat() / goal).coerceAtMost(1f),
            modifier = Modifier.fillMaxWidth()
        )
    }
}