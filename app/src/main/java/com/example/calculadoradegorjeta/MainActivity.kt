package com.example.calculadoradegorjeta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputPrice = findViewById<TextInputEditText>(R.id.edt_price_tip)
        val inputPorcentagem = findViewById<TextInputEditText>(R.id.edt_porcetagem_tip)
        val inputPessoas = findViewById<TextInputEditText>(R.id.edt_numero_pessoas)
        val btnLimpar = findViewById<Button>(R.id.btn_linpar)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val btnOpcaoUm = findViewById<Button>(R.id.btn_opcao_um)
        val btnOpcaoDois = findViewById<Button>(R.id.btn_opcao_dois)
        val btnOpcaoTres = findViewById<Button>(R.id.btn_opcao_tres)

        btnOpcaoUm.setOnClickListener {
            inputPorcentagem.setText("10")
        }
        btnOpcaoDois.setOnClickListener {
            inputPorcentagem.setText("15")
        }
        btnOpcaoTres.setOnClickListener {
            inputPorcentagem.setText("20")
        }

        btnLimpar.setOnClickListener {
            inputPrice.setText("")
            inputPorcentagem.setText("")
            inputPessoas.setText("")
        }

        btnCalcular.setOnClickListener {
            val strPesssoas: String = inputPessoas.text.toString()
            val strPrice: String = inputPrice.text.toString()
            val strPorcentagem: String = inputPorcentagem.text.toString()

            if (strPrice == "" || strPorcentagem == "" || strPesssoas == "") {
                Snackbar.make(
                    inputPrice,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {

                val price = strPrice.toFloat()
                val porcentagem = strPorcentagem.toFloat()
                val pessoas = strPesssoas.toFloat()

                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("KEY_PRICE", price)
                intent.putExtra("KEY_PORCENTAGEM", porcentagem)
                intent.putExtra("KEY_PESSOAS", pessoas)
                startActivity(intent)
            }
        }
    }
}