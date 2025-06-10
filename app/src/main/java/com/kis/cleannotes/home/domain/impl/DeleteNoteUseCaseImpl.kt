package com.kis.cleannotes.home.domain.impl

import com.kis.cleannotes.core.domain.model.Note
import com.kis.cleannotes.core.domain.repository.LocalDataSourceRepository
import com.kis.cleannotes.home.domain.DeleteNoteUseCase
import javax.inject.Inject

class DeleteNoteUseCaseImpl @Inject constructor (
    private val repository: LocalDataSourceRepository
) : DeleteNoteUseCase {

    override suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}