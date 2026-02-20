package com.example.codealpha_fitness_tracker_app.data.repository

import com.example.codealpha_fitness_tracker_app.data.local.dao.FitnessDao
import com.example.codealpha_fitness_tracker_app.data.local.entity.FitnessEntry
import kotlinx.coroutines.flow.Flow

class FitnessRepository(private val dao: FitnessDao) {
    suspend fun addEntry(entry: FitnessEntry) {
        dao.insert(entry)
    }
    fun getTodayEntries(date: String): Flow<List<FitnessEntry>> {
        return dao.getEntriesByDate(date)
    }
}