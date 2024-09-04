XML:

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <EditText
        android:id="@+id/number1_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Digite o primeiro número"
        android:inputType="numberDecimal"
        android:layout_marginBottom="8dp"/>

    <EditText
        android:id="@+id/number2_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Digite o segundo número"
        android:inputType="numberDecimal"
        android:layout_below="@id/number1_input"
        android:layout_marginBottom="16dp"/>

    <Button
        android:id="@+id/add_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Somar"
        android:layout_below="@id/number2_input"
        android:layout_marginBottom="8dp"/>

    <Button
        android:id="@+id/subtract_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Subtrair"
        android:layout_below="@id/add_button"
        android:layout_marginBottom="16dp"/>

    <TextView
        android:id="@+id/result_text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/subtract_button"
        android:textSize="18sp"/>
</RelativeLayout>

KOTLIN:

package com.example.primeiroprojetoandroid

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1Input = findViewById<EditText>(R.id.number1_input)
        val number2Input = findViewById<EditText>(R.id.number2_input)
        val addButton = findViewById<Button>(R.id.add_button)
        val subtractButton = findViewById<Button>(R.id.subtract_button)
        val resultText = findViewById<TextView>(R.id.result_text)

        addButton.setOnClickListener {
            val num1String = number1Input.text.toString()
            val num2String = number2Input.text.toString()

            if (num1String.isNotEmpty() && num2String.isNotEmpty()) {
                val num1 = num1String.toDouble()
                val num2 = num2String.toDouble()
                val sum = num1 + num2
                resultText.text = "Resultado da soma: $sum"
            } else {
                resultText.text = "Por favor, insira números válidos."
            }
        }

        subtractButton.setOnClickListener {
            val num1String = number1Input.text.toString()
            val num2String = number2Input.text.toString()

            if (num1String.isNotEmpty() && num2String.isNotEmpty()) {
                val num1 = num1String.toDouble()
                val num2 = num2String.toDouble()
                val difference = num1 - num2
                resultText.text = "Resultado da subtração: $difference"
            } else {
                resultText.text = "Por favor, insira números válidos."
            }
        }
    }
}
