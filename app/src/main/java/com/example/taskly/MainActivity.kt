package com.example.taskly

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.taskly.database.NoteDatabase
import com.example.taskly.repo.NoteRepository
import com.example.taskly.viewmodel.NoteViewModel
import com.example.taskly.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
    }
    private fun setupViewModel(){
         val noteRepository=NoteRepository(NoteDatabase.getInstance(this))
        val viewModelProviderFactory=ViewModelFactory(application,noteRepository)
        noteViewModel=ViewModelProvider(this,viewModelProviderFactory)[NoteViewModel::class.java]
    }
}