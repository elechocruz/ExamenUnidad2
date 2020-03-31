package com.example.examenunidad2

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class TareaDialog(private val position: Int): DialogFragment(){

    internal lateinit var listener: EliminarTareaDialogListener

    interface EliminarTareaDialogListener{
        fun onDialogPositiveClick(position: Int)
        fun onDialogNegativeClick(position: Int)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = context as EliminarTareaDialogListener
        } catch (e: ClassCastException) {
            // The activity doesn't implement the interface, throw exception
            throw ClassCastException((context.toString() +
                    " must implement NoticeDialogListener"))
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Desea eliminar la tarea: ")
            builder.setMessage("${Singleton.dataSet.get(position).titulo}")
                .setPositiveButton("Si",
                    DialogInterface.OnClickListener { dialog, id ->
                        listener.onDialogPositiveClick(position)
                    })
                .setNegativeButton("No",
                    DialogInterface.OnClickListener { dialog, id ->
                        listener.onDialogNegativeClick(position)
                        dismiss()
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}