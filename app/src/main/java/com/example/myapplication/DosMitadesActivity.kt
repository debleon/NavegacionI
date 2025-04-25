package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DosMitadesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dos_mitades)

        // Recibe el nombre del usuario
        val nombreUsuario = intent.getStringExtra("nombreUsuario") ?: "Usuario"
        val txtSaludo = findViewById<TextView>(R.id.txtSaludo)
        val edtTexto = findViewById<EditText>(R.id.edtTexto)
        val btnEjecutar = findViewById<Button>(R.id.btnEjecutar)
        val btnCerrar = findViewById<ImageView>(R.id.btnCerrar)

        // Menú inferior personalizado
        val btnMitades = findViewById<LinearLayout>(R.id.itemDosMitades)
        val btnPalabras = findViewById<LinearLayout>(R.id.itemDosPalabras)
        val btnFragmento = findViewById<LinearLayout>(R.id.itemQuitarFragmento)

        // Mostrar saludo
        txtSaludo.text = "Hola $nombreUsuario"

        // Botón cerrar
        btnCerrar.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        // Ejecutar lógica de Dos Mitades
        btnEjecutar.setOnClickListener {
            val input = edtTexto.text.toString().trim()
            if (input.isEmpty()) {
                Toast.makeText(this, "Por favor ingresa una cadena", Toast.LENGTH_SHORT).show()
            } else {
                val resultado = aplicarDosMitades(input)
                mostrarResultado(resultado)
            }
        }

        // Menú inferior (manual)
        btnMitades.setOnClickListener {
            Toast.makeText(this, "Ya estás en Dos mitades", Toast.LENGTH_SHORT).show()
        }

        btnPalabras.setOnClickListener {
            val intent = Intent(this, DosPalabrasActivity::class.java)
            intent.putExtra("nombreUsuario", nombreUsuario)
            startActivity(intent)
        }

        btnFragmento.setOnClickListener {
            val intent = Intent(this, QuitarFragmentoActivity::class.java)
            intent.putExtra("nombreUsuario", nombreUsuario)
            startActivity(intent)
        }
    }

    // Algoritmo Dos Mitades
    private fun aplicarDosMitades(cadena: String): String {
        val largo = cadena.length
        val mitad = (largo + 1) / 2
        val primera = cadena.substring(0, mitad)
        val segunda = cadena.substring(mitad)
        return segunda + primera
    }

    // Mostrar el resultado en un AlertDialog o con Toast (elige uno)
    private fun mostrarResultado(resultado: String) {
        try {
            val txtResultado = findViewById<TextView>(R.id.txtResultado)
            txtResultado.text = "$resultado"
        } catch (e: Exception) {
            Toast.makeText(this, "Error mostrando resultado: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

}