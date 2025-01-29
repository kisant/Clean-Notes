package com.kis.cleannotes.core.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kis.cleannotes.core.data.source.local.dao.NoteDao
import com.kis.cleannotes.core.data.source.local.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NotesRoomDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}