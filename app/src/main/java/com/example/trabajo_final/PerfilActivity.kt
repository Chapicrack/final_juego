package com.example.trabajo_final

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)
        val btnGastos = findViewById<Button>(R.id.btnGastos)
        val btnAhorros = findViewById<Button>(R.id.btnAhorros)
        val btnGrafico = findViewById<Button>(R.id.btnGrafico)
        val btnPerfil = findViewById<Button>(R.id.btnPerfil)

        btnGastos.setOnClickListener{navigatormainactivity() }
        btnAhorros.setOnClickListener{navigatorAhorros() }
        btnGrafico.setOnClickListener{navigatorGraficos() }
        btnPerfil.setOnClickListener{navigatorPerfil() }

    }
    private fun navigatormainactivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun navigatorAhorros() {
        val intent = Intent(this,AhorrosActivity::class.java)
        startActivity(intent)
    }
    private fun navigatorGraficos() {
        val intent = Intent(this,GraficosActivity::class.java)
        startActivity(intent)
    }
    private fun navigatorPerfil() {
        val intent = Intent(this,PerfilActivity::class.java)
        startActivity(intent)
    }
    }
