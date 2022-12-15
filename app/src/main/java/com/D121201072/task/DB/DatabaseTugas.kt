package com.D121201072.task.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [tugas::class], version = 1, exportSchema = false)
abstract class DatabaseTugas : RoomDatabase() {

    abstract fun gettugas_DAO() : tugasDAO

    companion object{
        @Volatile
        private var INSTANCE : DatabaseTugas? = null
        fun getDatabase(context: Context) : DatabaseTugas{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseTugas::class.java,
                    "tugas_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }


}