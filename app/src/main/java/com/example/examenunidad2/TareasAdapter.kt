package com.example.examenunidad2

import android.content.Intent
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_tarea.view.*

class TareasAdapter(private val longItemClickListener: (Int) -> Unit): RecyclerView.Adapter<TareasAdapter.ViewHolder>() {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val titulo = v.etTitulo
        val descripcion = v.etDescripcion
        val fecha = v.etFecha
        val materia = v.etMateria
        val estado = v.ivEstado
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tarea, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount() = Singleton.dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DatosTareas::class.java)

            intent.putExtra("titulo", Singleton.dataSet.get(position).titulo)
            intent.putExtra("descripcion", Singleton.dataSet.get(position).descripcion)
            intent.putExtra("fecha", Singleton.dataSet.get(position).fecha)
            intent.putExtra("materia", Singleton.dataSet.get(position).materia)
            intent.putExtra("estado", Singleton.dataSet.get(position).estado)
            intent.putExtra("position", position)

            holder.itemView.context.startActivity(intent)
        }

        holder.itemView.setOnLongClickListener {
            longItemClickListener.invoke(position)
            true
        }

        holder.titulo.text = Singleton.dataSet.get(position).titulo
        holder.descripcion.text = Singleton.dataSet.get(position).descripcion
        holder.fecha.text = Singleton.dataSet.get(position).fecha
        holder.materia.text = Singleton.dataSet.get(position).materia
        if (Singleton.dataSet.get(position).estado == "Pendiente") {
            holder.estado.setImageResource(R.drawable.ico_pendiente)
        }
        if (Singleton.dataSet.get(position).estado == "EnProgreso") {
            holder.estado.setImageResource(R.drawable.ico_enprogreso)
        }
        if (Singleton.dataSet.get(position).estado == "Hecho") {
            holder.estado.setImageResource(R.drawable.ico_hecho)
        }
    }
}