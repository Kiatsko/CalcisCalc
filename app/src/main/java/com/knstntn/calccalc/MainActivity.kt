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
        val editTxt = findViewById<TextView>(R.id.editTextNumberDecimal)
        val plus = findViewById<TextView>(R.id.buttonPlus)
        val minus = findViewById<TextView>(R.id.buttonMinus)
        val multiple = findViewById<TextView>(R.id.buttonMult)
        val divide = findViewById<TextView>(R.id.buttonDiv)
        val clean = findViewById<TextView>(R.id.buttonClean)
        val equals = findViewById<TextView>(R.id.buttonEq)

        val function = View.OnClickListener { view ->
            var nexnumber = editTxt.text.toString().toDoubleOrNull() ?: return@OnClickListener
            val nexoperation = when (view.id) {
                R.id.buttonPlus -> Operation.PLUS
                R.id.buttonMinus -> Operation.MINUS
                R.id.buttonMult -> Operation.MULTIPLE
                R.id.buttonDiv -> Operation.DIVIDE
                else -> null
            } ?: return@OnClickListener
            if (txView.text != "") {
                nexnumber = operation?.calc?.invoke(number!!, nexnumber) ?: 0.0
            }
            editTxt.text = ""
            number = nexnumber
            operation = nexoperation
            txView.text = "$nexnumber ${nexoperation.label}"
        }

        plus.setOnClickListener(function)
        minus.setOnClickListener(function)
        multiple.setOnClickListener(function)
        divide.setOnClickListener(function)

        clean.setOnClickListener {
            txView.text = ""
            editTxt.text = ""
            number = null
            operation = null
        }
        equals.setOnClickListener {
            val secnumber = editTxt.text.toString().toDoubleOrNull() ?: return@setOnClickListener

            number = operation!!.calc(number!!, secnumber)
            txView.text = "$number"
            editTxt.text = ""

        }
    }
}


enum class Operation(
    val label: String,
    val calc: (Double, Double) -> Double
) {
    PLUS(label = "+", calc = Double::plus),
    MINUS("-", Double::minus),
    MULTIPLE(
        "*",
        Double::times
    ),
    DIVIDE("/", Double::div)
}