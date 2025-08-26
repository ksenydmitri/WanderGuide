package com.ksenia.wanderguide.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.MapColumn
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ksenia.wanderguide.data.model.entity.CurrencyRate

@Dao
interface CurrencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRates(rates: List<CurrencyRate>)
    
    @Query("SELECT currency, rate FROM CurrencyRate ORDER BY date DESC LIMIT 1")
    suspend fun getCachedRates(): List<CurrencyRate>
}