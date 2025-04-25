package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnAtras = findViewById<ImageView>(R.id.btnAtras)
        val edtUsuario = findViewById<EditText>(R.id.edtUsuario)
        val edtClave = findViewById<EditText>(R.id.edtClave)
        val btnIngresar = findViewById<Button>(R.id.btnIngresar)

        btnAtras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnIngresar.setOnClickListener {
            val usuario = edtUsuario.text.toString().trim()
            val clave = edtClave.text.toString().trim()

            if (usuario.isEmpty() || clave.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, DosMitadesActivity::class.java)
                intent.putExtra("nombreUsuario", usuario)
                startActivity(intent)
            }
        }
    }
}
