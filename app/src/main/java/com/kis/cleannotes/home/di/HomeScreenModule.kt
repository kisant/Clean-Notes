package com.kis.cleannotes.home.di

import com.kis.cleannotes.home.domain.DeleteNoteUseCase
import com.kis.cleannotes.home.domain.GetAllNotesUseCase
import com.kis.cleannotes.home.domain.impl.DeleteNoteUseCaseImpl
import com.kis.cleannotes.home.domain.impl.GetAllNotesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeScreenModule {

    @Binds
    abstract fun bindDeleteNoteUseCase(
        deleteNoteUseCaseImpl: DeleteNoteUseCaseImpl
    ): DeleteNoteUseCase

    @Binds
    abstract fun bindGetAllNotesUseCase(
        getAllNotesUseCaseImpl: GetAllNotesUseCaseImpl
    ): GetAllNotesUseCase
}