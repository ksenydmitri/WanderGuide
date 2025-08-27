package com.ksenia.wanderguide.domain.repository

import com.ksenia.wanderguide.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    suspend fun saveNotes(notes: List<Note>): Unit
    suspend fun addNote(): Unit
    suspend fun updateNote(updatedNote: Note): Unit
    fun getNotesFlow(): Flow<List<Note>>
}