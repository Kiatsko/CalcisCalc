package com.knstntn.calccalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var operation: Operation? = null
    var number: Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txView = findViewById<TextView>(R.id.textView)
        val editTxt = findViewById<TextView>(R.id.editTextNumber)
        val plus = findViewById<TextView>(R.id.buttonPlus)
        val minus = findViewById<TextView>(R.id.buttonMinus)
        val multiple = findViewById<TextView>(R.id.buttonMult)
        val divide = findViewById<TextView>(R.id.buttonDiv)
        val clean = findViewById<TextView>(R.id.buttonClean)
        val equals = findViewById<TextView>(R.id.buttonEq)

        plus.setOnClickListener {
            val income = editTxt.text.toString().toDoubleOrNull() ?: return@setOnClickListener
            number = income
            operation = Operation.PLUS
        }
        minus.setOnClickListener {
            val income = editTxt.text.toString().toDoubleOrNull() ?: return@setOnClickListener
            number = income
            operation = Operation.MINUS
        }
        multiple.setOnClickListener {
            val income = editTxt.text.toString().toDoubleOrNull() ?: return@setOnClickListener
            number = income
            operation = Operation.MULTIPLE
        }
        divide.setOnClickListener {
            val income = editTxt.text.toString().toDoubleOrNull() ?: return@setOnClickListener
            number = income
            operation = Operation.DIVIDE
        }
    }
}

enum class Operation {
    PLUS, MINUS, MULTIPLE, DIVIDE
}