XML:

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <EditText
        android:id="@+id/password_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Digite a senha"
        android:inputType="textPassword"
        android:layout_marginBottom="16dp"/>

    <Button
        android:id="@+id/verify_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Verificar Senha"
        android:layout_below="@id/password_input"/>

    <TextView
        android:id="@+id/result_message"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/verify_button"
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

    private val correctPassword = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val passwordInput = findViewById<EditText>(R.id.password_input)
        val verifyButton = findViewById<Button>(R.id.verify_button)
        val resultMessage = findViewById<TextView>(R.id.result_message)

        verifyButton.setOnClickListener {
            val enteredPassword = passwordInput.text.toString()

            if (enteredPassword == correctPassword) {
                resultMessage.text = "Senha correta"
            } else {
                resultMessage.text = "Senha incorreta"
            }
        }
    }
}
