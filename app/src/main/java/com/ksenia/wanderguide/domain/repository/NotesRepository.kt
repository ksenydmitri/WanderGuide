package com.ksenia.wanderguide.domain.repository

import com.ksenia.wanderguide.domain.model.Note

interface NotesRepository {
    suspend fun fetchNotes(): List<Note>
    suspend fun saveNotes(notes: List<Note>): Unit
    suspend fun addNote(): Unit
    suspend fun updateNote(updatedNote: Note): Unit
}