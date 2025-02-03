package com.kis.cleannotes.core.data.source.local.di

import android.content.Context
import androidx.room.Room
import com.kis.cleannotes.core.data.repository.LocalDataSourceRepositoryImpl
import com.kis.cleannotes.core.data.source.local.LocalDataSource
import com.kis.cleannotes.core.data.source.local.RoomLocalDataSource
import com.kis.cleannotes.core.data.source.local.database.NotesRoomDatabase
import com.kis.cleannotes.core.domain.repository.LocalDataSourceRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalSourceModuleProvider {

    @Provides
    fun provideNoteDao(database: NotesRoomDatabase) = database.noteDao()

    @Provides
    @Singleton
    fun provideLocalDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NotesRoomDatabase::class.java,
        NotesRoomDatabase.DATABASE_NAME
    )
}

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModuleBinder {

    @Binds
    abstract fun bindRoomLocalDataSource(
        roomLocalDataSource: RoomLocalDataSource
    ): LocalDataSource //TODO: Why returns data source

    @Binds
    abstract fun bindDefaultCleanNotesRepository(
        defaultCleanNotesRepository: LocalDataSourceRepositoryImpl
    ): LocalDataSourceRepository //TODO: Why returns repository
}