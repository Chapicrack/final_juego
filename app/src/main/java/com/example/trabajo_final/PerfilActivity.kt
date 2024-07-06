package com.example.trabajo_final

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PerfilActivity : AppCompatActivity() {

    // Declaración de una variable para almacenar SharedPreferences
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Método para habilitar el modo de pantalla completa en dispositivos compatibles
        setContentView(R.layout.activity_perfil) // Establece el layout para esta actividad

        // Inicialización de SharedPreferences con un nombre de archivo y modo privado
        sharedPref = getSharedPreferences("com.example.trabajo_final.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE)

        // Encontrar vistas en el layout por sus identificadores
        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        val editTextEdad = findViewById<EditText>(R.id.editTextEdad)
        val checkBoxUniversitario = findViewById<CheckBox>(R.id.checkBoxUniversitario)
        val checkBoxTrabaja = findViewById<CheckBox>(R.id.checkBoxTrabaja)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnGastos = findViewById<Button>(R.id.btnGastos)
        val btnGrafico = findViewById<Button>(R.id.btnGrafico)
        val btnPerfil = findViewById<Button>(R.id.btnPerfil)

        // Restaurar datos guardados desde SharedPreferences y establecerlos en las vistas correspondientes
        editTextNombre.setText(sharedPref.getString("nombre", ""))
        editTextEdad.setText(sharedPref.getInt("edad", 0).toString())
        checkBoxUniversitario.isChecked = sharedPref.getBoolean("esUniversitario", false)
        checkBoxTrabaja.isChecked = sharedPref.getBoolean("trabaja", false)

        // Configurar el listener de clic para el botón "Guardar"
        btnGuardar.setOnClickListener {
            val nombre = editTextNombre.text.toString()
            val edad = editTextEdad.text.toString().toIntOrNull() ?: 0
            val esUniversitario = checkBoxUniversitario.isChecked
            val trabaja = checkBoxTrabaja.isChecked

            // Guardar datos en SharedPreferences utilizando el editor
            with(sharedPref.edit()) {
                putString("nombre", nombre)
                putInt("edad", edad)
                putBoolean("esUniversitario", esUniversitario)
                putBoolean("trabaja", trabaja)
                apply() // Aplicar cambios de forma asíncrona
            }
        }

        // Configurar listeners de clic para los botones de navegación
        btnGrafico.setOnClickListener { navigateGraficosActivity() }
        btnPerfil.setOnClickListener { navigatePerfilActivity() }
        btnGastos.setOnClickListener { navigateToMainActivity() }
    }

    // Función para navegar a MainActivity
    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    // Función para navegar a GraficosActivity
    private fun navigateGraficosActivity() {
        val intent = Intent(this, GraficosActivity::class.java)
        startActivity(intent)
    }

    // Función para navegar a PerfilActivity
    private fun navigatePerfilActivity() {
        val intent = Intent(this, PerfilActivity::class.java)
        startActivity(intent)
    }
}
