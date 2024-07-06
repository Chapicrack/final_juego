package com.example.trabajo_final

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class GraficosActivity : AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_graficos2)

        // Initialize SharedPreferences
        sharedPref = getSharedPreferences("com.example.trabajo_final.PREFERENCE_FILE_KEY", MODE_PRIVATE)

        // Find buttons in the layout
        val btnGastos = findViewById<Button>(R.id.btnGastos)
        val btnGrafico = findViewById<Button>(R.id.btnGrafico)
        val btnPerfil = findViewById<Button>(R.id.btnPerfil)

        // Set click listeners for navigation buttons
        btnGastos.setOnClickListener { navigatormainactivity() }
        btnGrafico.setOnClickListener { navigatorGraficos() }
        btnPerfil.setOnClickListener { navigatorPerfil() }

        // Retrieve and display saved data
        val savedNombre = sharedPref.getString("savedNombre", "")
        val savedCantidad = sharedPref.getString("savedCantidad", "")
        val savedPrecio = sharedPref.getString("savedPrecio", "")

        val tvNombre = findViewById<TextView>(R.id.textViewNombre)
        val tvCantidad = findViewById<TextView>(R.id.textViewCantidad)
        val tvPrecio = findViewById<TextView>(R.id.textViewPrecio)

        tvNombre.text = "Nombre: $savedNombre"
        tvCantidad.text = "Cantidad: $savedCantidad"
        tvPrecio.text = "Precio: $savedPrecio"
    }

    private fun navigatormainactivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigatorGraficos() {
        val intent = Intent(this, GraficosActivity::class.java)
        startActivity(intent)
    }

    private fun navigatorPerfil() {
        val intent = Intent(this, PerfilActivity::class.java)
        startActivity(intent)
    }
}
