package com.example.codealpha_fitness_tracker_app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.codealpha_fitness_tracker_app.data.local.entity.FitnessEntry
import kotlinx.coroutines.flow.Flow


@Dao
interface FitnessDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: FitnessEntry)

    @Query("SELECT * FROM fitness_entries WHERE date = :date")
    fun getEntriesByDate(date: String): Flow<List<FitnessEntry>>

}