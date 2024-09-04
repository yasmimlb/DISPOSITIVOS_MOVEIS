XML:

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <EditText
        android:id="@+id/height_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Digite a altura (em metros)"
        android:inputType="numberDecimal"
        android:layout_marginBottom="16dp"/>

    <EditText
        android:id="@+id/weight_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Digite o peso (em kg)"
        android:inputType="numberDecimal"
        android:layout_below="@id/height_input"
        android:layout_marginBottom="16dp"/>

    <Button
        android:id="@+id/calculate_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Calcular IMC"
        android:layout_below="@id/weight_input"/>

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

        val heightInput = findViewById<EditText>(R.id.height_input)
        val weightInput = findViewById<EditText>(R.id.weight_input)
        val calculateButton = findViewById<Button>(R.id.calculate_button)
        val resultText = findViewById<TextView>(R.id.result_text)

        calculateButton.setOnClickListener {
            val heightString = heightInput.text.toString()
            val weightString = weightInput.text.toString()

            if (heightString.isNotEmpty() && weightString.isNotEmpty()) {
                try {
                    val height = heightString.toDouble()
                    val weight = weightString.toDouble()

                    if (height > 0) {
                        val bmi = weight / (height * height)
                        val category = when {
                            bmi < 18.5 -> "Abaixo do peso"
                            bmi in 18.5..24.9 -> "Peso normal"
                            bmi in 25.0..29.9 -> "Sobrepeso"
                            else -> "Obesidade"
                        }

                        resultText.text = String.format("IMC: %.2f\nCategoria: %s", bmi, category)
                    } else {
                        resultText.text = "A altura deve ser maior que 0."
                    }
                } catch (e: NumberFormatException) {
                    resultText.text = "Insira valores válidos."
                }
            } else {
                resultText.text = "Preencha todos os campos."
            }
        }
    }
}
