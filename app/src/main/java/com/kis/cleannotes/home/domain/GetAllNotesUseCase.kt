package com.kis.cleannotes.home.domain

import com.kis.cleannotes.core.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface GetAllNotesUseCase {

    operator fun invoke(): Flow<List<Note>>
}