package com.ksenia.wanderguide.di

import android.content.Context
import androidx.room.Room
import com.ksenia.wanderguide.data.datasource.local.AppDatabase
import com.ksenia.wanderguide.data.datasource.local.CurrencyDao
import com.ksenia.wanderguide.data.datasource.local.NotesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).fallbackToDestructiveMigration(true)
            .build()
    }

    @Provides
    fun provideTrackDao(database: AppDatabase): CurrencyDao {
        return database.currencyDao()
    }

    @Provides
    fun provideNotesDao(database: AppDatabase): NotesDao {
        return database.notesDao()
    }
}