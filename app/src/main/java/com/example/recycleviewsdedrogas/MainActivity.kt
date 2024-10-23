package com.example.recycleviewsdedrogas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewsdedrogas.adapters.DrogaAdapter
import com.example.recycleviewsdedrogas.models.Droga
import com.example.recycleviewsdedrogas.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerDrogas)

        // Lista de drogas
        val drogas = listOf(
            Droga("Cocaína", "Estimulante", "Aumenta la energía y euforia.", R.drawable.cocaina),
            Droga("LSD", "Alucinógeno", "Provoca alucinaciones.", R.drawable.lsd),
            Droga("Éxtasis", "Estimulante", "Mejora el estado de ánimo.", R.drawable.extasis)
        )

        // Configurar el adaptador y el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DrogaAdapter(drogas) { droga ->
            val intent = Intent(this, DrogaDetailActivity::class.java).apply {
                putExtra("nombre", droga.nombre)
                putExtra("tipo", droga.tipo)
                putExtra("descripcion", droga.descripcion)
                putExtra("imagen", droga.imagen)
            }
            startActivity(intent)
        }
    }
}