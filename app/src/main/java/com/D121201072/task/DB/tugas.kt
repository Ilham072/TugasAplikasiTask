package com.D121201072.task.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tugas_tabel")
class tugas (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id : Int = 0,
    @ColumnInfo(name = "isi") val isi: String,
    @ColumnInfo(name = "kategori") val kategori: String)
