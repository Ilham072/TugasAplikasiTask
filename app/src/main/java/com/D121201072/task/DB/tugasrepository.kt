package com.D121201072.task.DB

class tugasrepository (private val tugas_DAO : tugasDAO) {
    val allNotes = tugas_DAO.getAllNotes()

    suspend fun insert(note : tugas){
        tugas_DAO.insert(note)
    }

    suspend fun delete(note : tugas){
        tugas_DAO.delete(note)
    }

    fun update(note : tugas){
        tugas_DAO.update(note)
    }
}