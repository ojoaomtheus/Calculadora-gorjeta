package com.example.calculadoradegorjeta

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val valorPrice = intent.getFloatExtra("KEY_PRICE", 0f)
        val valorPorcentagem = intent.getFloatExtra("KEY_PORCENTAGEM", 0f)

        val resultado = valorPrice * (valorPorcentagem / 100)
        val totalValor = resultado + valorPrice


        val tvPrice = findViewById<TextView>(R.id.price)
        val tvResultado = findViewById<TextView>(R.id.porcetagem_valor)
        val tvtotalValor = findViewById<TextView>(R.id.total_valor)

        tvPrice.text = valorPrice.toString()
        tvResultado.text = resultado.toString()
        tvtotalValor.text = totalValor.toString()
    }
}