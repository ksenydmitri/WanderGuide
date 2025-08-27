package com.ksenia.wanderguide.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrencyRateEntity(
    @PrimaryKey val currency: String,
    val rate: Double,
    val date: String
)