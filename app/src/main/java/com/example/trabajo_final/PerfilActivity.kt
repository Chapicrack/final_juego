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

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)

        // Initialize SharedPreferences
        sharedPref = getSharedPreferences("com.example.trabajo_final.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE)

        // Find views
        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        val editTextEdad = findViewById<EditText>(R.id.editTextEdad)
        val checkBoxUniversitario = findViewById<CheckBox>(R.id.checkBoxUniversitario)
        val checkBoxTrabaja = findViewById<CheckBox>(R.id.checkBoxTrabaja)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnGastos = findViewById<Button>(R.id.btnGastos)
        val btnGrafico = findViewById<Button>(R.id.btnGrafico)
        val btnPerfil = findViewById<Button>(R.id.btnPerfil)

        // Restore saved data
        editTextNombre.setText(sharedPref.getString("nombre", ""))
        editTextEdad.setText(sharedPref.getInt("edad", 0).toString())
        checkBoxUniversitario.isChecked = sharedPref.getBoolean("esUniversitario", false)
        checkBoxTrabaja.isChecked = sharedPref.getBoolean("trabaja", false)

        // Set click listener for guardar button
        btnGuardar.setOnClickListener {
            val nombre = editTextNombre.text.toString()
            val edad = editTextEdad.text.toString().toIntOrNull() ?: 0
            val esUniversitario = checkBoxUniversitario.isChecked
            val trabaja = checkBoxTrabaja.isChecked

            // Save data to SharedPreferences
            with(sharedPref.edit()) {
                putString("nombre", nombre)
                putInt("edad", edad)
                putBoolean("esUniversitario", esUniversitario)
                putBoolean("trabaja", trabaja)
                apply()
            }
        }

        // Set click listeners for navigation buttons
        btnGastos.setOnClickListener { navigateMainActivity() }
        btnGrafico.setOnClickListener { navigateGraficosActivity() }
        btnPerfil.setOnClickListener { navigatePerfilActivity() }
    }

    private fun navigateMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateGraficosActivity() {
        val intent = Intent(this, GraficosActivity::class.java)
        startActivity(intent)
    }

    private fun navigatePerfilActivity() {
        val intent = Intent(this, PerfilActivity::class.java)
        startActivity(intent)
    }
}
