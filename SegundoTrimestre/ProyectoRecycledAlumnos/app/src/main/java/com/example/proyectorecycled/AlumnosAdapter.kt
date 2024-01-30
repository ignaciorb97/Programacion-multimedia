// Importaciones necesarias
package com.example.proyectorecycled

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//nombre asignatura y nota
// Definición de la clase del adaptador
class AlumnosAdapter(private val alumnosList: List<Alumnos>) :
    RecyclerView.Adapter<AlumnosAdapter.PersonViewHolder>() {

    // Método llamado cuando se necesita crear un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            PersonViewHolder {
        // Inflar el diseño del elemento de la lista desde XML
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        // Crear y devolver una instancia del ViewHolder
        return PersonViewHolder(view)
    }

    // Método llamado para mostrar datos en una posición específica
    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        // Obtener la persona en la posición actual
        val person = alumnosList[position]
        // Establecer el texto en el TextView del ViewHolder
        holder.nameTextView.text = person.name + " " + person.asignatura +" "+ person.nota
    }

    // Método que devuelve la cantidad total de elementos en el conjunto de datos
    override fun getItemCount(): Int = alumnosList.size

    // Clase interna que representa un ViewHolder
    class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Referencia al TextView en el diseño del elemento de la lista
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
    }
}
