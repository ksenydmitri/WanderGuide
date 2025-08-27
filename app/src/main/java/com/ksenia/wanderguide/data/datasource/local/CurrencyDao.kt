package com.ksenia.wanderguide.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ksenia.wanderguide.data.model.entity.CurrencyRateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRates(rates: List<CurrencyRateEntity>)

    @Query("SELECT * FROM CurrencyRateEntity")
    fun getRatesFlow(): Flow<List<CurrencyRateEntity>>
}