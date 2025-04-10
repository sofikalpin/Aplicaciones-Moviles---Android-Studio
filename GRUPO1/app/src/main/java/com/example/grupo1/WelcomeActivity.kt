package com.example.grupo1

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var imgPlatformLogo: ImageView
    private lateinit var etOtraPreferencia: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Texto de bienvenida personalizado
        val usuario = intent.getStringExtra("usuario")
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = "¡Bienvenido/a, $usuario!"

        // RadioGroup para seleccionar plataforma
        val rgPlatform = findViewById<RadioGroup>(R.id.rgPlatform)
        imgPlatformLogo = findViewById(R.id.imgPlatformLogo)

        rgPlatform.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbAndroid -> imgPlatformLogo.setImageResource(R.drawable.android_logo)
                R.id.rbIOS -> imgPlatformLogo.setImageResource(R.drawable.ioslogo)
            }
        }

        // Mostrar EditText si se marca "Otra"
        val cbOtra = findViewById<CheckBox>(R.id.cbOtra)
        etOtraPreferencia = findViewById(R.id.etOtraPreferencia)

        cbOtra.setOnCheckedChangeListener { _, isChecked ->
            etOtraPreferencia.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        // Botón continuar (opcionalmente podés usarlo para enviar info o cambiar de pantalla)
        val btnContinuar = findViewById<Button>(R.id.btnContinuar)
        btnContinuar.setOnClickListener {
            Toast.makeText(this, "Gracias por elegir tus preferencias", Toast.LENGTH_SHORT).show()
        }
    }
}
