package com.example.trabajo_final

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class GraficosActivity : AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences
    private lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_graficos2)

        // Inicializar SharedPreferences para acceder a los datos guardados
        sharedPref = getSharedPreferences("com.example.trabajo_final.PREFERENCE_FILE_KEY", MODE_PRIVATE)

        // Encontrar botones y spinner en el layout
        val btnGastos = findViewById<Button>(R.id.btnGastos)
        val btnGrafico = findViewById<Button>(R.id.btnGrafico)
        val btnPerfil = findViewById<Button>(R.id.btnPerfil)
        spinner = findViewById(R.id.spinnerEntries)

        // Configurar listeners para los botones de navegación
        btnGastos.setOnClickListener { navegarAMainActivity() }
        btnGrafico.setOnClickListener { /* No es necesario navegar a la misma actividad */ }
        btnPerfil.setOnClickListener { navegarAPerfilActivity() }

        // Recuperar y mostrar datos guardados
        val entriesString = sharedPref.getString("entries", "")
        val entries = if (entriesString.isNullOrEmpty()) listOf<Entry>() else entriesString.split("|").map { Entry.fromString(it) }

        // Crear una lista de cadenas para mostrar en el Spinner
        val entryStrings = entries.map { "Nombre: ${it.nombre}, Cantidad: ${it.cantidad}, Precio: ${it.precio}" }

        // Configurar el Spinner con el adaptador
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, entryStrings)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    private fun navegarAMainActivity() {
        // Navegar a MainActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navegarAPerfilActivity() {
        // Navegar a PerfilActivity
        val intent = Intent(this, PerfilActivity::class.java)
        startActivity(intent)
    }
}