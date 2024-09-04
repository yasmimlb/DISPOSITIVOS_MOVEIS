XML:

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <!-- EditText para o valor a ser convertido -->
    <EditText
        android:id="@+id/amount_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Digite o valor"
        android:inputType="numberDecimal"
        android:layout_marginBottom="16dp"/>

    <!-- EditText para a taxa de conversão -->
    <EditText
        android:id="@+id/conversion_rate_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Digite a taxa de conversão (ex: 5.00)"
        android:inputType="numberDecimal"
        android:layout_below="@id/amount_input"
        android:layout_marginBottom="16dp"/>

    <!-- Botão para converter o valor -->
    <Button
        android:id="@+id/convert_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Converter"
        android:layout_below="@id/conversion_rate_input"/>

    <!-- TextView para exibir o resultado -->
    <TextView
        android:id="@+id/result_text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/convert_button"
        android:layout_marginTop="16dp"
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

        val amountInput = findViewById<EditText>(R.id.amount_input)
        val conversionRateInput = findViewById<EditText>(R.id.conversion_rate_input)
        val convertButton = findViewById<Button>(R.id.convert_button)
        val resultText = findViewById<TextView>(R.id.result_text)

        convertButton.setOnClickListener {
            val amountString = amountInput.text.toString()
            val conversionRateString = conversionRateInput.text.toString()

            if (amountString.isNotEmpty() && conversionRateString.isNotEmpty()) {
                try {
                    val amount = amountString.toDouble()
                    val conversionRate = conversionRateString.toDouble()

                    val convertedAmount = amount * conversionRate

                    resultText.text = String.format("Valor convertido: %.2f", convertedAmount)
                } catch (e: NumberFormatException) {
                    resultText.text = "Insira valores válidos."
                }
            } else {
                resultText.text = "Preencha todos os campos."
            }
        }
    }
}
