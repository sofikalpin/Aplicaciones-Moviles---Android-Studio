package com.example.grupo1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val textViewWelcome = findViewById<TextView>(R.id.textViewWelcome)
        val usuario = intent.getStringExtra("usuario")
        textViewWelcome.text = "¡Bienvenido, $usuario!"
    }
}
