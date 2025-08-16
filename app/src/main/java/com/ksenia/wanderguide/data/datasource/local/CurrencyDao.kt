package com.ksenia.wanderguide.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CurrencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRates(rates: Map<String, Double>, date: String)

    @Query("SELECT * FROM CurrencyRate")
    suspend fun getCachedRates(): Map<String, Double>
}