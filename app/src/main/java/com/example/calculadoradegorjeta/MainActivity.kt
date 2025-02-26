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

        val inputPrice = findViewById<TextInputEditText>(R.id.edt_price_tip)
        val inputPorcentagem = findViewById<TextInputEditText>(R.id.edt_percentage_of_tip)
        val inputPessoas = findViewById<TextInputEditText>(R.id.edt_number_of_people)
        val btnLimpar = findViewById<Button>(R.id.btn_clean)
        val btnCalcular = findViewById<Button>(R.id.btn_calculate)
        val btnOpcaoUm = findViewById<Button>(R.id.btn_option_one)
        val btnOpcaoDois = findViewById<Button>(R.id.btn_option_two)
        val btnOpcaoTres = findViewById<Button>(R.id.btn_option_three)

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
            val strPesssoas = inputPessoas.text.toString()
            val strPrice = inputPrice.text.toString()
            val strPorcentagem = inputPorcentagem.text.toString()

            if (strPrice.isEmpty() && strPorcentagem.isEmpty() && strPesssoas.isEmpty()) {
                Snackbar.make(
                    inputPrice,
                    "FIIL IN ALL FIELDS",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {

                val price = strPrice.toFloat()
                val porcentagem = strPorcentagem.toInt()
                val pessoas = strPesssoas.toInt()

                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("KEY_PRICE", price)
                intent.putExtra("KEY_PERCENTAGE", porcentagem)
                intent.putExtra("KEY_PEOPLE", pessoas)
                startActivity(intent)
            }
        }
    }
}