package com.D121201072.task

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.D121201072.task.DB.DatabaseTugas
import com.D121201072.task.DB.tugas
import com.D121201072.task.DB.tugasrepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class tugasViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes : LiveData<List<tugas>>
    private val repository : tugasrepository

    init {
        val dao = DatabaseTugas.getDatabase(application).gettugas_DAO()
        repository = tugasrepository(dao)
        allNotes = repository.allNotes
    }

    fun insertNote(note : tugas) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }

    fun deleteNote(note : tugas) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(note)
    }

    fun update(note : tugas) = viewModelScope.launch(Dispatchers.IO){
        repository.update(note)
    }
}