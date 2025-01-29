package com.kis.cleannotes.core.data.source.local

import com.kis.cleannotes.core.data.domain.model.Note
import kotlinx.coroutines.flow.Flow

// Abstraction from the Room database and increased flexibility
interface LocalDataSource {
    fun getAllNotesFlow(): Flow<List<Note>>
    fun getNoteByIdFlow(id: Int): Flow<Note>
    suspend fun insertNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(note: Note)
}