package com.D121201072.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.D121201072.task.DB.tugas
import com.D121201072.task.databinding.ActivityTambahTugasBinding

class TambahTugasActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTambahTugasBinding
    private lateinit var viewModel: tugasViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahTugasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[tugasViewModel::class.java]

        val button : Button = findViewById(R.id.simpan_btn)
        val items = listOf("Penting Mendesak","Tidak Penting Mendesak","Penting Tidak Mendesak","Tidak Penting Tidak Mendesak")
        val adapter = ArrayAdapter(this,R.layout.dropdown_kategori,items)
        binding.kategori.setAdapter(adapter)

        if(intent.getIntExtra("code",0)==2){
            binding.isi.setText(intent.getStringExtra("isi"))
            binding.kategori.setText(intent.getStringExtra("kategori"))
            binding.simpanBtn.setText("Edit")
        }

        button.setOnClickListener{
            addingNote(intent.getIntExtra("code",0))
        }

        binding.backButton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun addingNote(code : Int){
        val isi : EditText = findViewById(R.id.isi)
        val kategori : EditText = findViewById(R.id.kategori)
        val submit1= isi.text.toString()
        val submit2 = kategori.text.toString()


        if(submit1.isNotEmpty() && submit2.isNotEmpty()){
            if(code==1){
                viewModel.insertNote(tugas(0,submit1,submit2))
            }else{
                viewModel.update(tugas(intent.getIntExtra("id",0),submit1,submit2))
            }

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Kategori & Isi Harus Di Isi",Toast.LENGTH_SHORT).show()
        }
    }
}