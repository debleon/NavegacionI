package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DosPalabrasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dos_palabras)

        // Recibe el nombre del usuario
        val nombreUsuario = intent.getStringExtra("nombreUsuario") ?: "Usuario"

        // Referencias a las vistas
        val txtSaludo = findViewById<TextView>(R.id.txtSaludo)
        val edtTexto = findViewById<EditText>(R.id.edtTexto)
        val btnEjecutar = findViewById<Button>(R.id.btnEjecutar)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btnCerrar = findViewById<ImageView>(R.id.btnCerrar)

        // Menú inferior
        val btnMitades = findViewById<LinearLayout>(R.id.itemDosMitades)
        val btnPalabras = findViewById<LinearLayout>(R.id.itemDosPalabras)
        val btnFragmento = findViewById<LinearLayout>(R.id.itemQuitarFragmento)

        // Mostrar saludo
        txtSaludo.text = "Hola $nombreUsuario"

        // Botón cerrar
        btnCerrar.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Botón ejecutar algoritmo
        btnEjecutar.setOnClickListener {
            val input = edtTexto.text.toString().trim()
            val resultado = dosPalabras(input)
            txtResultado.text = resultado
        }

        // Navegación inferior
        btnMitades.setOnClickListener {
            val intent = Intent(this, DosMitadesActivity::class.java)
            intent.putExtra("nombreUsuario", nombreUsuario)
            startActivity(intent)
        }

        btnPalabras.setOnClickListener {
            Toast.makeText(this, "Ya estás en Dos palabras", Toast.LENGTH_SHORT).show()
        }

        btnFragmento.setOnClickListener {
            val intent = Intent(this, QuitarFragmentoActivity::class.java)
            intent.putExtra("nombreUsuario", nombreUsuario)
            startActivity(intent)
        }
    }

    // Algoritmo: Intercambiar dos palabras si hay exactamente dos
    private fun dosPalabras(cadena: String): String {
        val partes = cadena.split(" ")

        return if (partes.size == 2) {
            "${partes[1]} ${partes[0]}"
        } else {
            "Error: Debes ingresar exactamente dos palabras separadas por un espacio"
        }
    }
}