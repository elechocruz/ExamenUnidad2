Examen practico - Gerardo Alexis Barbosa Cruz 
El examen consiste en una aplicacion, para llevar un control de mis tareas pendientes, se agrega un nombre, descripcion, materia, fecha
y estado a una tarea.
En la lista de tareas, al darle clic veras mas a detalle las tareas y podras cambiar el estado de estas, teniendo un circulo verde
si estan hechas, un circulo rojo si no estan hechas y un circulo amarillo si estan en proceso. 
Tambien hay un boton para que te recuerde de una tarea con la alarma del celular.

**Requisitos y su aplicacion:** 
**- Al menos una intencion explicita:** 
  Se aplica para cambiar de MainActivity a TareasActivity por medio del metodo cambiarListaTareas()
 **- Al menos una intencion implicita:** 
  Se aplica en la clase DatosTareas en el evento de click recordarTarea() del boton btnRecordarTarea que se contiene en el FirstFragment
 **- Al menos un tipo de menú:**  
  Se aplica en la clase DatosTareas en el evento de click showPopup() del ImageView ivstat que se contiene en el FirstFragment.
  Al presionarlo te permitira cambiar el estado en el que se encuentra la tarea, podiendo ponerlo entre Hecho, En proceso y Pendiente
 **- Toolbar en lugar de ActionBar:** 
  Se usa en las activities de TareasActivity y en DatosTareas cuyos xml son activity_tareas y activity_datos_tareas para ponerle
  un titulo a las activity
 **- Toast:**   
  Se usa al agregar una nueva tarea como mensaje de que se agrego correctamente.
 **- Snackbar:**   
  Se usa al eliminar una tarea para poder deshacer la accion.
 **- RecyclerView:**   
  Se usa para mostrar todas las tareas en la clase TareasActivity
 **- Al menos un fragment:**   
  El fragment lo contiene la clase DatosTareas y se usa para mostrar mas por separado los detalles de una tarea.
 **- Al menos un cuadro de dialogo:**   
  Se usa al mantener presionado un elemento del RecyclerView para eliminarlo.
 **- Al menos 5 diferentes widget "basicos", usados:
   * TextView
   * EditText
   * Button
   * ImageView
   * Spinner
