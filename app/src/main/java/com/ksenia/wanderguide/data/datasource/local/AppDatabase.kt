package com.ksenia.wanderguide.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ksenia.wanderguide.data.model.entity.CurrencyRateEntity
import com.ksenia.wanderguide.data.model.entity.NoteEntity

@Database(
    entities = [CurrencyRateEntity::class, NoteEntity::class],
    version = 3,
    exportSchema = false
)
@TypeConverters
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
    abstract fun notesDao(): NotesDao
}