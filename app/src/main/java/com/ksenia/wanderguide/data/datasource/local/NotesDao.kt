package com.ksenia.wanderguide.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ksenia.wanderguide.data.model.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(noteEntities: List<NoteEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM noteentity ORDER BY createdAt DESC")
    suspend fun getNotes(): List<NoteEntity>

    @Query("SELECT * FROM noteentity ORDER BY createdAt DESC")
    fun getNotesFlow(): Flow<List<NoteEntity>>
}