package com.example.recycleviewsdedrogas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewsdedrogas.R
import com.example.recycleviewsdedrogas.models.Droga

class DrogaAdapter(
    private val drogas: List<Droga>,
    private val onItemClick: (Droga) -> Unit
) : RecyclerView.Adapter<DrogaAdapter.DrogaViewHolder>() {

    inner class DrogaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nombre = view.findViewById<TextView>(R.id.txtNombre)
        private val tipo = view.findViewById<TextView>(R.id.txtTipo)
        private val imagen = view.findViewById<ImageView>(R.id.imgDroga)

        fun bind(droga: Droga) {
            nombre.text = droga.nombre
            tipo.text = droga.tipo
            imagen.setImageResource(droga.imagen)

            itemView.setOnClickListener { onItemClick(droga) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrogaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_droga, parent, false)
        return DrogaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrogaViewHolder, position: Int) {
        holder.bind(drogas[position])
    }

    override fun getItemCount() = drogas.size
}
