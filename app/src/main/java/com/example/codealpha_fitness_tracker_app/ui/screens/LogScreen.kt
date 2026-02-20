package com.example.codealpha_fitness_tracker_app.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codealpha_fitness_tracker_app.ViewModel.FitnessViewModel


@Composable
fun LogScreen(viewModel: FitnessViewModel, padding: PaddingValues) {

    var type by remember { mutableStateOf("Steps") }
    var value by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(padding)
            .padding(16.dp)
    ) {

        Text("Log Activity", style = MaterialTheme.typography.headlineSmall)

        Spacer(Modifier.height(16.dp))

        DropdownMenuBox(type) { type = it }

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = value,
            onValueChange = { value = it },
            label = { Text("Value") }
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            if (value.isNotEmpty()) {
                viewModel.addEntry(type, value.toInt())
                value = ""
            }
        }) {
            Text("Add Entry")
        }

    }
}

@Composable
fun DropdownMenuBox(selected: String, onSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val options = listOf("Steps", "Calories", "Workout")

    Box {
        Button(onClick = { expanded = true }) {
            Text(selected)
        }

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach {
                DropdownMenuItem(
                    text = { Text(it) },
                    onClick = {
                        onSelected(it)
                        expanded = false
                    }
                )
            }
        }
    }

}