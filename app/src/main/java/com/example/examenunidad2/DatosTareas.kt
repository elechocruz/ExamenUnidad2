package com.example.examenunidad2

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_datos_tareas.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.item_tarea.*
import java.time.LocalDateTime

class DatosTareas : AppCompatActivity() {

    lateinit var str: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_tareas)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.title = "Datos de la Tarea"
        var pos = intent.getIntExtra("position", 0)
        str = pos.toString()
    }

    fun showPopup(view: View) {
        var pos = str.toInt()
        var popup: PopupMenu? = null;
        popup = PopupMenu(this, view)
        popup.inflate(R.menu.menu)

        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

            when (item!!.itemId) {
                R.id.hecho -> {
                    ivstat.setImageResource(R.drawable.ico_hecho)
                    val tarea = Singleton.dataSet[pos]
                    Singleton.dataSet.removeAt(pos)
                    Singleton.dataSet.add(pos,Tarea(tarea.titulo,tarea.descripcion,tarea.fecha,tarea.materia,"Hecho"))

                }
                R.id.progreso -> {
                    ivstat.setImageResource(R.drawable.ico_enprogreso)
                    val tarea = Singleton.dataSet[pos]
                    Singleton.dataSet.removeAt(pos)
                    Singleton.dataSet.add(pos,Tarea(tarea.titulo,tarea.descripcion,tarea.fecha,tarea.materia,"EnProgreso"))

                }
                R.id.pendiente -> {
                    ivstat.setImageResource(R.drawable.ico_pendiente)
                    val tarea = Singleton.dataSet[pos]
                    Singleton.dataSet.removeAt(pos)
                    Singleton.dataSet.add(pos,Tarea(tarea.titulo,tarea.descripcion,tarea.fecha,tarea.materia,"Pendiente"))
                }
            }

            true
        })
        popup.show()
    }

    fun recordarTarea(view: View) {
        var pos = str.toInt()
        val tarea = Singleton.dataSet[pos]
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, "Tarea: ${tarea.titulo}")
            putExtra(AlarmClock.EXTRA_HOUR, 12)
            putExtra(AlarmClock.EXTRA_MINUTES, 0)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}

