package com.kis.cleannotes.core.data.mapper

import com.kis.cleannotes.core.data.domain.model.Note
import com.kis.cleannotes.core.data.source.local.model.NoteEntity

fun NoteEntity.toNote() = Note(id, title, description)
fun Note.toNoteEntity() = NoteEntity(id, title, description)