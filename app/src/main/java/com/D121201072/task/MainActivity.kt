package com.D121201072.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.D121201072.task.DB.tugas

class MainActivity : AppCompatActivity(), IAdaptor {

    private lateinit var viewModel : tugasViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview : RecyclerView = findViewById(R.id.recycler_view)
        recyclerview.layoutManager  = LinearLayoutManager(this)
        val adapter = AdapterTugas(this)
        recyclerview.adapter = adapter

        viewModel = ViewModelProvider(this).get(tugasViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {
            adapter.updateTugas(it)
        })
    }

    fun tambahtugas(view:View){
        val intent = Intent(this,TambahTugasActivity::class.java)
        intent.putExtra("code",1)
        startActivity(intent)
    }

    override fun onDeleteClick(note : tugas){
        viewModel.deleteNote(note)
    }
}