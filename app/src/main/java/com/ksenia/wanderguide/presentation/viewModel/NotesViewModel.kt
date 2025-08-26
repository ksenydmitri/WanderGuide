package com.ksenia.wanderguide.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ksenia.wanderguide.domain.model.Note
import com.ksenia.wanderguide.domain.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel@Inject constructor(
    private val repository: NotesRepository
): ViewModel() {

    val notes = MutableLiveData<List<Note>>()

    fun loadNotes() {
        viewModelScope.launch {
            val result = repository.fetchNotes()
            notes.postValue(result)
        }
    }

    fun updateNoteCompletion(id: String, newState: Boolean){

    }

}