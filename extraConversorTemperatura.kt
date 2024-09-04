XML:

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <EditText
        android:id="@+id/temperature_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Digite a temperatura"
        android:inputType="numberDecimal"
        android:layout_marginBottom="16dp"/>

    <RadioGroup
        android:id="@+id/conversion_group"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/temperature_input"
        android:layout_marginBottom="16dp">

        <RadioButton
            android:id="@+id/celsius_to_fahrenheit"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Celsius para Fahrenheit"/>

        <RadioButton
            android:id="@+id/fahrenheit_to_celsius"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Fahrenheit para Celsius"/>
    </RadioGroup>

    <Button
        android:id="@+id/convert_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Converter"
        android:layout_below="@id/conversion_group"/>

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
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val temperatureInput = findViewById<EditText>(R.id.temperature_input)
        val conversionGroup = findViewById<RadioGroup>(R.id.conversion_group)
        val celsiusToFahrenheit = findViewById<RadioButton>(R.id.celsius_to_fahrenheit)
        val fahrenheitToCelsius = findViewById<RadioButton>(R.id.fahrenheit_to_celsius)
        val convertButton = findViewById<Button>(R.id.convert_button)
        val resultText = findViewById<TextView>(R.id.result_text)

        convertButton.setOnClickListener {
            val temperatureString = temperatureInput.text.toString()

            if (temperatureString.isNotEmpty()) {
                try {
                    val temperature = temperatureString.toDouble()
                    var result: Double

                    when (conversionGroup.checkedRadioButtonId) {
                        R.id.celsius_to_fahrenheit -> {
                            result = (temperature * 9 / 5) + 32
                            resultText.text = String.format("Temperatura em Fahrenheit: %.2f", result)
                        }
                        R.id.fahrenheit_to_celsius -> {
                            result = (temperature - 32) * 5 / 9
                            resultText.text = String.format("Temperatura em Celsius: %.2f", result)
                        }
                        else -> resultText.text = "Selecione o tipo de conversão."
                    }
                } catch (e: NumberFormatException) {
                    resultText.text = "Insira um número válido."
                }
            } else {
                resultText.text = "Digite a temperatura."
            }
        }
    }
}
