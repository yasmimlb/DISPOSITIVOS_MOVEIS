XML:

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <EditText
        android:id="@+id/guess_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Digite seu palpite (1 a 100)"
        android:inputType="number"
        android:layout_marginBottom="16dp"/>

    <Button
        android:id="@+id/check_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Verificar"
        android:layout_below="@id/guess_input"/>

    <TextView
        android:id="@+id/result_text"
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
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var targetNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateRandomNumber()

        val guessInput = findViewById<EditText>(R.id.guess_input)
        val checkButton = findViewById<Button>(R.id.check_button)
        val resultText = findViewById<TextView>(R.id.result_text)

        checkButton.setOnClickListener {
            val guessString = guessInput.text.toString()

            if (guessString.isNotEmpty()) {
                try {
                    val guess = guessString.toInt()

                    // Verificar o palpite
                    when {
                        guess < targetNumber -> resultText.text = "Seu palpite é muito baixo."
                        guess > targetNumber -> resultText.text = "Seu palpite é muito alto."
                        guess == targetNumber -> resultText.text = "Parabéns! Você acertou."
                    }
                } catch (e: NumberFormatException) {
                    resultText.text = "Insira um número válido."
                }
            } else {
                resultText.text = "Digite um palpite."
            }
        }
    }

    private fun generateRandomNumber() {
        targetNumber = Random.nextInt(1, 101) // Gera um número entre 1 e 100
    }
}
