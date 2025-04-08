package com.example.grupo1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val editTextNewUser = findViewById<EditText>(R.id.editTextNewUsername)
        val editTextNewPass = findViewById<EditText>(R.id.editTextNewPassword)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)

        buttonRegister.setOnClickListener {
            val newUser = editTextNewUser.text.toString()
            val newPass = editTextNewPass.text.toString()

            if (newUser.isNotBlank() && newPass.isNotBlank()) {
                val resultIntent = Intent()
                resultIntent.putExtra("usuario", newUser)
                resultIntent.putExtra("clave", newPass)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

}