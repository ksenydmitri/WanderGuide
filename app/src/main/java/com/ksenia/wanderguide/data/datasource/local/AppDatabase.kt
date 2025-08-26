package com.ksenia.wanderguide.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ksenia.wanderguide.data.model.entity.CurrencyRate
import com.ksenia.wanderguide.data.model.entity.NoteEntity

@Database(
    entities = [CurrencyRate::class, NoteEntity::class],
    version = 2,
    exportSchema = false
)
@TypeConverters
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
    abstract fun notesDao(): NotesDao
}