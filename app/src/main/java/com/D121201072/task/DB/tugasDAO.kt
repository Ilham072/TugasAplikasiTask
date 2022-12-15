package com.D121201072.task.DB

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
abstract class tugasDAO {

    @Query("SELECT * FROM tugas_tabel ORDER BY id ASC")
    abstract fun getAllNotes() : LiveData<List<tugas>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(tugas: tugas)

    @Delete
    abstract fun delete(tugas: tugas)

    @Update
    abstract fun update(tugas: tugas)
}