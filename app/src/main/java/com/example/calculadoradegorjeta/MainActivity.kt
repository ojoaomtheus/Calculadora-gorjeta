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
        val btnCalcular = findViewById<Button>(R.id.calcular)
        val btnPorcento10 = findViewById<Button>(R.id.btn_10)
        val btnPorcento25 = findViewById<Button>(R.id.btn_25)
        val btnPorcento50 = findViewById<Button>(R.id.btn_50)

        btnPorcento10.setOnClickListener {
            inputPorcentagem.setText("10")
        }
        btnPorcento25.setOnClickListener {
            inputPorcentagem.setText("25")
        }
        btnPorcento50.setOnClickListener {
            inputPorcentagem.setText("50")
        }

        btnCalcular.setOnClickListener {
            val strPrice: String = inputPrice.text.toString()
            val strPorcentagem: String = inputPorcentagem.text.toString()

            if (strPrice == "" || strPorcentagem == "") {
                Snackbar.make(
                    inputPrice,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {

                val price = strPrice.toFloat()
                val porcentagem = strPorcentagem.toFloat()

                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("KEY_PRICE", price)
                intent.putExtra("KEY_PORCENTAGEM", porcentagem)
                startActivity(intent)
            }
        }
    }
}