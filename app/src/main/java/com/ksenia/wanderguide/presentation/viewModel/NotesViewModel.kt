package com.ksenia.wanderguide.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ksenia.wanderguide.domain.model.Note
import com.ksenia.wanderguide.domain.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val repository: NotesRepository
) : ViewModel() {

    val notes: StateFlow<List<Note>> = repository.getNotesFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addNote() {
        viewModelScope.launch {
            repository.addNote()
        }
    }

    fun toggleNoteCompletion(note: Note) {
        viewModelScope.launch {
            val updatedNote = note.copy(isCompleted = !note.isCompleted)
            repository.updateNote(updatedNote)
        }
    }

    fun updateNoteText(note: Note, newText: String) {
        viewModelScope.launch {
            val updatedNote = note.copy(
                text = newText,
                createdAt = LocalDateTime.now().toString()
            )
            repository.updateNote(updatedNote)
        }
    }
}
