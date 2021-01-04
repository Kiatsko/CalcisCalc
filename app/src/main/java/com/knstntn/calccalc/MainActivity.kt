package com.knstntn.calccalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var operation: Operation? = null
    var number: Double? = null
    var result = 0.0
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
            if (txView.text == "") {
                number = editTxt.text.toString().toDoubleOrNull() ?: return@OnClickListener

                when (view.id) {
                    R.id.buttonPlus -> {
                        operation = Operation.PLUS
                        txView.text = "$number +"
                    }
                    R.id.buttonMinus -> {
                        operation = Operation.MINUS
                        txView.text = "$number -"
                    }
                    R.id.buttonMult -> {
                        operation = Operation.MULTIPLE
                        txView.text = "$number *"
                    }
                    R.id.buttonDiv -> {
                        operation = Operation.DIVIDE
                        txView.text = "$number /"
                    }
                }

                editTxt.text = ""
            } else {
                val nexnumber = editTxt.text.toString().toDoubleOrNull() ?: return@OnClickListener
                when (view.id) {
                    R.id.buttonPlus -> {
                        result = number!! + nexnumber
                        txView.text = "$result +"
                    }
                    R.id.buttonMinus -> {result = number!! - nexnumber
                        txView.text = "$result -"
                    }
                    R.id.buttonMult -> {result = number!! * nexnumber
                        txView.text = "$result *"
                    }
                    R.id.buttonDiv -> {result = number!! / nexnumber
                        txView.text = "$result /"
                    }
                }


                editTxt.text = ""
                number = result
            }
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

            when (operation) {
                Operation.PLUS -> result = number!! + secnumber
                Operation.MINUS -> result = number!! - secnumber
                Operation.MULTIPLE -> result = number!! * secnumber
                Operation.DIVIDE -> result = number!! / secnumber
            }
            txView.text = "$result"
            editTxt.text = ""

        }
    }
}

enum class Operation {
    PLUS, MINUS, MULTIPLE, DIVIDE
}