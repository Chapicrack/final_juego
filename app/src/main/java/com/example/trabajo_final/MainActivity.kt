package com.example.trabajo_final

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnGastos = findViewById<Button>(R.id.btnGastos)
        val btnGrafico = findViewById<Button>(R.id.btnGrafico)
        val btnPerfil = findViewById<Button>(R.id.btnPerfil)
        val btnIngresos = findViewById<Button>(R.id.btningresos)
        val btnTransporte = findViewById<Button>(R.id.btnTransporte)
        val btnComida = findViewById<Button>(R.id.btnComida)
        val btnTrabajos = findViewById<Button>(R.id.btnTrabajos)
        val btnSuscripciones = findViewById<Button>(R.id.btnSuscripciones)
        val btnSalidas = findViewById<Button>(R.id.btnSalidas)
        val btnSnacks = findViewById<Button>(R.id.btnSnacks)
        val btnAccesorios = findViewById<Button>(R.id.btnAccesorios)
        val btnUtilidad = findViewById<Button>(R.id.btnUtilidad)
        val btnExtras = findViewById<Button>(R.id.btnExtras)
        val btnDeudas = findViewById<Button>(R.id.btnDeudas)

        btnTransporte.setOnClickListener { navigatorCalculadora() }
        btnComida.setOnClickListener { navigatorCalculadora() }
        btnTrabajos.setOnClickListener { navigatorCalculadora() }
        btnSuscripciones.setOnClickListener { navigatorCalculadora() }
        btnSalidas.setOnClickListener { navigatorCalculadora() }
        btnSnacks.setOnClickListener { navigatorCalculadora() }
        btnAccesorios.setOnClickListener { navigatorCalculadora() }
        btnUtilidad.setOnClickListener { navigatorCalculadora() }
        btnExtras.setOnClickListener { navigatorCalculadora() }
        btnGrafico.setOnClickListener { navigatorGraficos() }
        btnPerfil.setOnClickListener { navigatorPerfil() }
    }

    private fun navigatorCalculadora() {
        val intent = Intent(this, activityCalculadora::class.java)
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
