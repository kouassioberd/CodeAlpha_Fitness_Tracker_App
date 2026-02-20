package com.example.codealpha_fitness_tracker_app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.codealpha_fitness_tracker_app.data.local.dao.FitnessDao
import com.example.codealpha_fitness_tracker_app.data.local.entity.FitnessEntry


@Database(
    entities = [FitnessEntry::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun fitnessDao() : FitnessDao
}