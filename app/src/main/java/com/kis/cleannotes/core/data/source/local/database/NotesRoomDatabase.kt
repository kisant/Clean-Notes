package com.kis.cleannotes.core.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kis.cleannotes.core.data.source.local.dao.NoteDao
import com.kis.cleannotes.core.data.source.local.database.NotesRoomDatabase.Companion.DATABASE_VERSION
import com.kis.cleannotes.core.data.source.local.model.NoteEntity

@Database(entities = [NoteEntity::class], version = DATABASE_VERSION)
abstract class NotesRoomDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        const val DATABASE_NAME = "clean_notes_db"
        const val DATABASE_VERSION = 1
    }
}