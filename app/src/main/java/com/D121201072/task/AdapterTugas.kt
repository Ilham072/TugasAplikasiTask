package com.D121201072.task

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.D121201072.task.DB.tugas

class AdapterTugas(private val listener:IAdaptor) : RecyclerView.Adapter<AdapterTugas.TugasViewHolder>() {

    private val allNotes = ArrayList<tugas>()
    var context:Context?=null


    class TugasViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val isi: TextView = itemView.findViewById(R.id.isi)
        val kategori: TextView = itemView.findViewById(R.id.kategori)
        val delete : ImageView = itemView.findViewById(R.id.delete)
        val edit : ImageView = itemView.findViewById(R.id.edit)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TugasViewHolder {
        val viewHolder = TugasViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_tugas,parent,false))
        context = parent.context
        viewHolder.delete.setOnClickListener{
            listener.onDeleteClick((allNotes[viewHolder.adapterPosition]))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: TugasViewHolder, position: Int) {
        val currentItem = allNotes[position]
        holder.isi.text = currentItem.isi
        holder.kategori.text = currentItem.kategori

        holder.edit.setOnClickListener {
            val intent  = Intent(context,TambahTugasActivity::class.java)
            intent.putExtra("isi",currentItem.isi)
            intent.putExtra("kategori",currentItem.kategori)
            intent.putExtra("id",currentItem.id)
            intent.putExtra("code",2)
            context!!.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateTugas(Tugasbaru : List<tugas>){
        allNotes.clear()
        allNotes.addAll(Tugasbaru)
        notifyDataSetChanged()
    }

}
interface IAdaptor{
    fun onDeleteClick(note : tugas)
}