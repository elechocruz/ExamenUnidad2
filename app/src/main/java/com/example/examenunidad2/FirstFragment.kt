package com.example.examenunidad2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.item_tarea.*
import kotlin.properties.Delegates

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var titulo = activity?.intent?.getStringExtra("titulo")
        var descripcion = activity?.intent?.getStringExtra("descripcion")
        var fecha = activity?.intent?.getStringExtra("fecha")
        var materia = activity?.intent?.getStringExtra("materia")
        var estado = activity?.intent?.getStringExtra("estado")

        tvTitulo.text = titulo
        tvDescripcion.text = descripcion
        tvFecha.text = fecha
        tvMateria.text = materia

        if(estado == "Pendiente"){
            ivstat.setImageResource(R.drawable.ico_pendiente)
        }
        if(estado == "Hecho"){
            ivstat.setImageResource(R.drawable.ico_hecho)
        }
        if(estado == "EnProgreso"){
            ivstat.setImageResource(R.drawable.ico_enprogreso)
        }
    }
}
