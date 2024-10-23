package com.example.recycleviewsdedrogas

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DrogaDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_droga_detail)

        val nombre = findViewById<TextView>(R.id.txtNombreDetail)
        val tipo = findViewById<TextView>(R.id.txtTipoDetail)
        val descripcion = findViewById<TextView>(R.id.txtDescripcionDetail)
        val imagen = findViewById<ImageView>(R.id.imgDrogaDetail)

        intent?.let {
            nombre.text = it.getStringExtra("nombre")
            tipo.text = it.getStringExtra("tipo")
            descripcion.text = it.getStringExtra("descripcion")
            imagen.setImageResource(it.getIntExtra("imagen", 0))
        }
    }
}
