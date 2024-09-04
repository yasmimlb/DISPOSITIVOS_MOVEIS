XML

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <EditText
        android:id="@+id/age_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Digite sua idade"
        android:inputType="number"
        android:layout_marginBottom="16dp"/>

    <Button
        android:id="@+id/check_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Verificar Idade"/>

    <TextView
        android:id="@+id/age_message"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/check_button"
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

        val ageInput = findViewById<EditText>(R.id.age_input)
        val checkButton = findViewById<Button>(R.id.check_button)
        val ageMessage = findViewById<TextView>(R.id.age_message)

        checkButton.setOnClickListener {
            val ageString = ageInput.text.toString()

            if (ageString.isNotEmpty()) {
                val age = ageString.toInt()

                val message = when {
                    age < 18 -> "Você é menor de idade."
                    age in 18..60 -> "Você está na meia idade."
                    else -> "Você é idoso."
                }
                ageMessage.text = message

            } else {
                ageMessage.text = "Por favor, insira uma idade válida."
            }
        }
    }
}
