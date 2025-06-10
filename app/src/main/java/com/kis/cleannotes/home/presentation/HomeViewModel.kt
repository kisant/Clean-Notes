package com.kis.cleannotes.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kis.cleannotes.core.domain.model.Note
import com.kis.cleannotes.home.domain.DeleteNoteUseCase
import com.kis.cleannotes.home.domain.GetAllNotesUseCase
import com.kis.cleannotes.home.presentation.HomeUiEvent.OnDeleteClick
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

internal sealed interface HomeUiEvent {
    data class OnDeleteClick(val note: Note): HomeUiEvent
}

internal sealed interface HomeUiState {
    data object Empty: HomeUiState
    data class Content(val notes: List<Note>): HomeUiState
}

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
): ViewModel() {

    private val notes: Flow<List<Note>> = getAllNotesUseCase()

    fun handleEvent(event: HomeUiEvent) {
        when(event) {
            is OnDeleteClick -> deleteNote(event.note)
        }
    }

    val uiState: StateFlow<HomeUiState> = notes.map { notes ->
        if (notes.isNotEmpty()) {
            HomeUiState.Content(notes)
        } else {
            HomeUiState.Empty
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HomeUiState.Empty
    )

    private fun deleteNote(note: Note) = viewModelScope.launch {
        deleteNoteUseCase(note)
    }
}