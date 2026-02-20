package com.example.codealpha_fitness_tracker_app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "fitness_entries")
data class FitnessEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val type: String,   // Steps / Workout / Calories
    val value: Int,
    val date: String    // "YYYY-MM-DD"
)
