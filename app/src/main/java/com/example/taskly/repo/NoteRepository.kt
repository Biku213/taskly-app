package com.example.taskly.repo

import com.example.taskly.database.NoteDatabase
import com.example.taskly.models.Note

class NoteRepository(private val db:NoteDatabase) {

    suspend fun insertNote(note : Note) = db.noteDao().insertNote(note)
    suspend fun deleteNote(note : Note) = db.noteDao().deleteNote(note)
    suspend fun updateNote(note : Note) = db.noteDao().updateNote(note)

    fun getAllNotes() = db.noteDao().getAllNotes()
    fun searchNote(query: String?) = db.noteDao().searchNote(query)

}