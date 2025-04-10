package com.example.grupo1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val validUsername = "Juan Torres"
    private val validPassword = "1234utn"

    private var registeredUsername: String? = null
    private var registeredPassword: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)
        val textClickHere = findViewById<TextView>(R.id.textViewClickHere)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            // Log para depuración
            println("Username ingresado: '$username'")
            println("Password ingresado: '$password'")

            val esValido = (username == validUsername && password == validPassword) ||
                    (username == registeredUsername && password == registeredPassword)

            if (esValido) {
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("usuario", username)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                // Ayuda visual para depuración
                println("Credenciales esperadas: '$validUsername' / '$validPassword'")
                println("Credenciales registradas: '$registeredUsername' / '$registeredPassword'")
            }
        }

        // Ambos botones llevan al registro
        val goToRegister = {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent, 1)
        }

        textClickHere.setOnClickListener { goToRegister() }
        buttonRegister.setOnClickListener { goToRegister() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            registeredUsername = data.getStringExtra("usuario")
            registeredPassword = data.getStringExtra("clave")
            Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()

            // Log para confirmar que los datos se recibieron correctamente
            println("Usuario registrado: '$registeredUsername'")
            println("Contraseña registrada: '$registeredPassword'")
        }
    }
}