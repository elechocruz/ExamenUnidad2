package com.example.examenunidad2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_datos_tareas.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tareas.*
import kotlinx.android.synthetic.main.activity_tareas.toolbar

class TareasActivity : AppCompatActivity(), TareaDialog.EliminarTareaDialogListener {

    val onLongItemClickListener: (Int) -> Unit = {position->
        Toast.makeText(this, "Eliminar la tarea: ${Singleton.dataSet.get(position).titulo}", Toast.LENGTH_LONG).show()

        DialogEliminarTarea(position)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tareas)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.title = "Mi lista de Tareas"

        recyclerView.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        recyclerView.adapter = TareasAdapter(onLongItemClickListener)
        recyclerView.adapter?.notifyDataSetChanged()
        //LlenarPrueba()
    }
    fun LlenarPrueba(){
        Singleton.dataSet.add(Tarea("Examen unidad 2","Examen de ciclos LISP","31/03/2020","Prolog","Pendiente"))
        Singleton.dataSet.add(Tarea("Examen unidad 2","Examen de intenciones, menus, fragments y otras cosas","01/04/2020","Movil 1","Hecho"))
        Singleton.dataSet.add(Tarea("Practica IIS","Realizar practica de instalacion y configuracion IIS","02/04/2020","Administracion de redes","EnProgreso"))

    }

    fun DialogEliminarTarea(position: Int){
        val dialog = TareaDialog(position)
        dialog.show(supportFragmentManager, "DialogEliminarTarea")
    }

    override fun onDialogPositiveClick(position: Int) {
        val tarea = Singleton.dataSet.get(position)
        Singleton.dataSet.removeAt(position)
        //recyclerView.adapter?.notifyItemRemoved(position)
        recyclerView.adapter?.notifyDataSetChanged()

        Snackbar.make(recyclerView, "Tarea eliminado ${tarea.titulo}", Snackbar.LENGTH_SHORT)
            .setAction("Deshacer", {
                Singleton.dataSet.add(position, tarea)
                //recyclerView.adapter?.notifyItemInserted(position)
                recyclerView.adapter?.notifyDataSetChanged()
            }).show()
    }

    override fun onDialogNegativeClick(position: Int) {
        Toast.makeText(this, "No se elimino la tarea", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        recyclerView.adapter?.notifyDataSetChanged()
    }
}