package com.example.codealpha_fitness_tracker_app.ui.screens

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.codealpha_fitness_tracker_app.ViewModel.FitnessViewModel


@Composable
fun  FitnessApp(viewModel: FitnessViewModel) {

    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    label = { Text( "Dashboard") },
                    icon = {}
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    label = { Text( "Log") },
                    icon = {}
                )
            }
        }
    ) { padding ->

        when(selectedTab) {
            0 -> DashboardScreen(viewModel, padding)
            1 -> LogScreen(viewModel, padding)
        }

    }
}