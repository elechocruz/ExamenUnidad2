package com.example.examenunidad2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val elementos = arrayOf("Moviles 1","Moviles 2","Administracion de Redes","Sistemas programables", "Prolog")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, elementos)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spMateria.adapter = adaptador
    }

    fun AgregarTarea(view: View) {
        Toast.makeText(this, "Tarea agregada!!!", Toast.LENGTH_LONG).show()
        val tarea = Tarea("${etTitulo.text}","${etDescripcion.text}","${etFecha.text}","${spMateria.selectedItem}","Pendiente")
        Singleton.dataSet.add(tarea)
        etTitulo.text.clear()
        etDescripcion.text.clear()
        etFecha.text.clear()

    }

    fun cambiarListaTareas(view: View) {
        startActivity(Intent(this, TareasActivity::class.java))
    }
}
