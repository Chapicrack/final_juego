package com.example.trabajo_final

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnGastos = findViewById<Button>(R.id.btnGastos)
        val btnAhorros = findViewById<Button>(R.id.btnAhorros)
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
        val btnPrestamos = findViewById<Button>(R.id.btnPrestamos)


    }
}