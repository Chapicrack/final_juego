package com.example.trabajo_final

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class activityCalculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadorta)

        val recibirNombre = findViewById<EditText>(R.id.recibirnombre)
        val recibirCantidad = findViewById<EditText>(R.id.recibircantidad)
        val recibirPrecio = findViewById<EditText>(R.id.recibirprecio)

        val btnGastos = findViewById<Button>(R.id.btnGastos)
        val btnAhorros = findViewById<Button>(R.id.btnAhorros)
        val btnGrafico = findViewById<Button>(R.id.btnGrafico)
        val btnPerfil = findViewById<Button>(R.id.btnPerfil)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnEliminar = findViewById<Button>(R.id.btneliminar)

        btnGastos.setOnClickListener { navigatormainactivity() }
        btnPerfil.setOnClickListener { navigatorPerfil() }

        btnSave.setOnClickListener {
            val nombre = recibirNombre.text.toString()
            val cantidad = recibirCantidad.text.toString()
            val precio = recibirPrecio.text.toString()

            if (nombre.isNotEmpty() && cantidad.isNotEmpty() && precio.isNotEmpty()) {
                saveInputText(nombre, cantidad, precio)
                Toast.makeText(this, "Información guardada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        btnEliminar.setOnClickListener {
            recibirNombre.text.clear()
            recibirCantidad.text.clear()
            recibirPrecio.text.clear()
            Toast.makeText(this, "Campos eliminados", Toast.LENGTH_SHORT).show()
        }

        btnGrafico.setOnClickListener {
            navigatorGraficos()
        }
    }

    private fun saveInputText(nombre: String, cantidad: String, precio: String) {
        val sharedPref = getSharedPreferences("com.example.trabajo_final.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("savedNombre", nombre)
            putString("savedCantidad", cantidad)
            putString("savedPrecio", precio)
            apply()
        }
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