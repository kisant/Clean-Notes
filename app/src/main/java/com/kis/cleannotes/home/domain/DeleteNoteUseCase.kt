package com.kis.cleannotes.home.domain

import com.kis.cleannotes.core.domain.model.Note

interface DeleteNoteUseCase {

    suspend operator fun invoke(note: Note)
}