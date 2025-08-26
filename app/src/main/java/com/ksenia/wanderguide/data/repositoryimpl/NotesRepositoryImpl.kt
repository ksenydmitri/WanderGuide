package com.ksenia.wanderguide.data.repositoryimpl

import android.R.attr.text
import com.ksenia.wanderguide.data.datasource.local.NotesDao
import com.ksenia.wanderguide.data.model.entity.NoteEntity
import com.ksenia.wanderguide.domain.model.Note
import com.ksenia.wanderguide.domain.repository.NotesRepository
import java.time.LocalDateTime
import java.util.UUID
import javax.inject.Inject

class NotesRepositoryImpl@Inject constructor(
    val notesDao: NotesDao
) : NotesRepository {
    override suspend fun fetchNotes(): List<Note> {
        try {
            val notes = notesDao.getNotes().map { noteEntity ->
                Note(
                    id = noteEntity.id,
                    text = noteEntity.text,
                    isCompleted = noteEntity.isCompleted,
                    createdAt = noteEntity.createdAt
                )
            }

            return notes
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun saveNotes(notes: List<Note>) {
        try {
            val noteEntities = notes.map { note ->
                NoteEntity(
                    id = UUID.randomUUID().toString(),
                    text = note.text,
                    isCompleted = note.isCompleted,
                    createdAt = LocalDateTime.now().toString()
                )
            }
            notesDao.insertNotes(noteEntities)
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun addNote() {
        try {
            val newNote = NoteEntity(
                id = UUID.randomUUID().toString(),
                text = "Новая заметка",
                isCompleted = false,
                createdAt = LocalDateTime.now().toString()
            )
            notesDao.insertNote(newNote)
        } catch (e: Exception){
            throw e
        }
    }

    override suspend fun updateNote(updatedNote: Note) {
        try {
            notesDao.insertNote(NoteEntity(
                id = updatedNote.id,
                text = updatedNote.text,
                isCompleted = updatedNote.isCompleted,
                createdAt = updatedNote.createdAt

            ))
        } catch (e: Exception){
            throw e
        }
    }
}