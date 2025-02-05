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

        val price = intent.getFloatExtra("KEY_PRICE", 0f)
        val percentage = intent.getIntExtra("KEY_PERCENTAGE", 0)
        val numberOfPeople = intent.getIntExtra("KEY_PEOPLE", 0)

        val calculation = price * (percentage / 100)
        val totalCalculation = calculation + price
        val pricePerPeople = totalCalculation / numberOfPeople


        val tvPrice = findViewById<TextView>(R.id.tv_price)
        val tvPricePerPerson = findViewById<TextView>(R.id.tv_price_per_person)
        val tvPercentage = findViewById<TextView>(R.id.tv_percentage)
        val tvNumberPeople = findViewById<TextView>(R.id.tv_number_of_people)
        val btnNovoCal = findViewById<Button>(R.id.btn_new_calculation)

        tvPrice.text = price.toString()
        tvNumberPeople.text = numberOfPeople.toString()
        tvPercentage.text = percentage.toString() + "%"
        tvPricePerPerson.text = ("%.2f").format(pricePerPeople)

        btnNovoCal.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}