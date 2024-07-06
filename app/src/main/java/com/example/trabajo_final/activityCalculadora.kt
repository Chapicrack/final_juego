package com.example.trabajo_final

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

// Clase de datos para representar una entrada de gasto
data class Entry(val nombre: String, val cantidad: Int, val precio: Float) {
    override fun toString(): String {
        return "$nombre,$cantidad,$precio" // Formato de cadena para almacenar en SharedPreferences
    }

    companion object {
        // Función para crear una Entry desde una cadena formateada almacenada en SharedPreferences
        fun fromString(entryString: String): Entry {
            val parts = entryString.split(",")
            return Entry(parts[0], parts[1].toInt(), parts[2].toFloat())
        }
    }
}

// Actividad principal para la calculadora de gastos
class activityCalculadora : AppCompatActivity() {

    private var totalGastos: Float = 0f  // Variable para mantener el total de gastos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadorta) // Establecer el layout de la actividad

        // Referencias a los elementos de la interfaz de usuario
        val recibirNombre = findViewById<EditText>(R.id.recibirnombre)
        val recibirCantidad = findViewById<EditText>(R.id.recibircantidad)
        val recibirPrecio = findViewById<EditText>(R.id.recibirprecio)

        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnEliminar = findViewById<Button>(R.id.btneliminar)
        val btnGrafico = findViewById<Button>(R.id.btnGrafico)
        val btnPerfil = findViewById<Button>(R.id.btnPerfil)
        val btnGastos = findViewById<Button>(R.id.btnGastos)

        // Configurar listener para el botón de guardar
        btnSave.setOnClickListener {
            val nombre = recibirNombre.text.toString()
            val cantidad = recibirCantidad.text.toString()
            val precio = recibirPrecio.text.toString()

            // Verificar que todos los campos estén completos
            if (nombre.isNotEmpty() && cantidad.isNotEmpty() && precio.isNotEmpty()) {
                val cantidadInt = cantidad.toInt()
                val precioFloat = precio.toFloat()

                // Guardar la entrada de gasto y actualizar el total
                saveInputText(nombre, cantidadInt, precioFloat)
                totalGastos += cantidadInt * precioFloat
                actualizarTotalGastos()  // Actualizar TextView con el total de gastos
                Toast.makeText(this, "Información guardada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar listener para el botón de eliminar campos
        btnEliminar.setOnClickListener {
            recibirNombre.text.clear()
            recibirCantidad.text.clear()
            recibirPrecio.text.clear()
            Toast.makeText(this, "Campos eliminados", Toast.LENGTH_SHORT).show()
        }

        // Configurar listener para el botón de ir a la actividad de gráficos
        btnGrafico.setOnClickListener {
            val intent = Intent(this, GraficosActivity::class.java)
            startActivity(intent)
        }

        // Configurar listeners para los botones de navegación
        btnGastos.setOnClickListener { navigateToMainActivity() }
        btnPerfil.setOnClickListener { navigateToPerfilActivity() }
    }

    // Función para guardar la entrada de gasto en SharedPreferences
    private fun saveInputText(nombre: String, cantidad: Int, precio: Float) {
        val sharedPref = getSharedPreferences("com.example.trabajo_final.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE)

        // Leer la lista actual de entradas guardadas
        val entriesString = sharedPref.getString("entries", "")
        val entries = if (entriesString.isNullOrEmpty()) mutableListOf<Entry>() else entriesString.split("|").map { Entry.fromString(it) }.toMutableList()

        // Agregar la nueva entrada a la lista
        val newEntry = Entry(nombre, cantidad, precio)
        entries.add(newEntry)

        // Guardar la lista actualizada de entradas en SharedPreferences
        val updatedEntriesString = entries.joinToString(separator = "|") { it.toString() }
        with(sharedPref.edit()) {
            putString("entries", updatedEntriesString)
            apply()
        }
    }

    // Función para actualizar el TextView con el total de gastos
    private fun actualizarTotalGastos() {
        val tvTotalGastos = findViewById<TextView>(R.id.textViewTotalGastos)
        tvTotalGastos.text = "Total de Gastos: $${String.format("%.2f", totalGastos)}"
    }

    // Función para navegar a la actividad principal (MainActivity)
    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    // Función para navegar a la actividad de perfil (PerfilActivity)
    private fun navigateToPerfilActivity() {
        val intent = Intent(this, PerfilActivity::class.java)
        startActivity(intent)
    }
}
