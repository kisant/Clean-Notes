package com.kis.cleannotes.core.data.source.local

import com.kis.cleannotes.core.domain.model.Note
import com.kis.cleannotes.core.data.mapper.toNote
import com.kis.cleannotes.core.data.mapper.toNoteEntity
import com.kis.cleannotes.core.data.source.local.dao.NoteDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomLocalDataSource @Inject constructor(
    private val noteDao: NoteDao
) : LocalDataSource {

    override fun getAllNotesFlow(): Flow<List<Note>> {
        return noteDao.getAllNotes().map { noteEntityList ->
            noteEntityList.map { it.toNote() }
        }
    }

    override fun getNoteByIdFlow(id: Int): Flow<Note> {
        return noteDao.getNoteById(id).map { it.toNote() }
    }

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note.toNoteEntity())
    }

    override suspend fun updateNote(note: Note) {
        noteDao.updateNote(note.toNoteEntity())
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.delete(note.toNoteEntity())
    }
}