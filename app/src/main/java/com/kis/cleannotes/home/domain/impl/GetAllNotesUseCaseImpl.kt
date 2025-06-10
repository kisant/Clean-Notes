package com.kis.cleannotes.home.domain.impl

import com.kis.cleannotes.core.domain.model.Note
import com.kis.cleannotes.core.domain.repository.LocalDataSourceRepository
import com.kis.cleannotes.home.domain.GetAllNotesUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllNotesUseCaseImpl @Inject constructor(
    private val repository: LocalDataSourceRepository
) : GetAllNotesUseCase {

    override operator fun invoke() = repository.getAllNotesFlow()
}