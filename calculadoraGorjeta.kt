XML:

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <EditText
        android:id="@+id/bill_amount_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Digite o valor da conta"
        android:inputType="numberDecimal"
        android:layout_marginBottom="16dp"/>

    <EditText
        android:id="@+id/tip_percentage_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Digite a porcentagem da gorjeta (ex: 10, 15, 20)"
        android:inputType="numberDecimal"
        android:layout_below="@id/bill_amount_input"
        android:layout_marginBottom="16dp"/>

    <Button
        android:id="@+id/calculate_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Calcular Gorjeta"
        android:layout_below="@id/tip_percentage_input"/>

    <TextView
        android:id="@+id/result_text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/calculate_button"
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

        val billAmountInput = findViewById<EditText>(R.id.bill_amount_input)
        val tipPercentageInput = findViewById<EditText>(R.id.tip_percentage_input)
        val calculateButton = findViewById<Button>(R.id.calculate_button)
        val resultText = findViewById<TextView>(R.id.result_text)

        calculateButton.setOnClickListener {
            val billAmountString = billAmountInput.text.toString()
            val tipPercentageString = tipPercentageInput.text.toString()

            if (billAmountString.isNotEmpty() && tipPercentageString.isNotEmpty()) {
                try {
                    val billAmount = billAmountString.toDouble()
                    val tipPercentage = tipPercentageString.toDouble()

                    val tipAmount = billAmount * (tipPercentage / 100)
                    val totalAmount = billAmount + tipAmount

                    resultText.text = String.format(
                        "Gorjeta: %.2f\nTotal: %.2f",
                        tipAmount,
                        totalAmount
                    )
                } catch (e: NumberFormatException) {
                    resultText.text = "Insira valores válidos."
                }
            } else {
                resultText.text = "Preencha todos os campos."
            }
        }
    }
}
