package com.example.calculadoradegorjeta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
        val valorPorPessoa = intent.getFloatExtra("KEY_PESSOAS", 0f)

        val porcentagem = valorPrice * (valorPorcentagem / 100)
        val totalValor = porcentagem + valorPrice
        val valorPessoa = totalValor / valorPorPessoa


        val tvPrecoPessoa = findViewById<TextView>(R.id.tv_valor_por_pessoa)
        val tvPorcentagem = findViewById<TextView>(R.id.tv_porcetagem_valor)
        val tvtotalValor = findViewById<TextView>(R.id.tv_total_valor)
        val btnNovoCal = findViewById<Button>(R.id.btn_novo_calculo)

        tvtotalValor.text = ("%.2f").format(totalValor)
        tvPorcentagem.text = ("%.2f").format(porcentagem)
        tvPrecoPessoa.text = ("%.2f").format(valorPessoa)

        btnNovoCal.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}