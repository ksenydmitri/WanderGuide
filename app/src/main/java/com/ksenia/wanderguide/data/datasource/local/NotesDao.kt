package com.ksenia.wanderguide.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ksenia.wanderguide.data.model.entity.NoteEntity

@Dao
interface NotesDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(noteEntities: List<NoteEntity>)

    @Query("SELECT * FROM noteentity")
    suspend fun getNotes(): List<NoteEntity>
}