package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class QuitarFragmentoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quitar_fragmento)

        // Obtener nombre del usuario
        val nombreUsuario = intent.getStringExtra("nombreUsuario") ?: "Usuario"

        // Referencias a vistas
        val txtSaludo = findViewById<TextView>(R.id.txtSaludo)
        val edtTexto = findViewById<EditText>(R.id.edtTexto)
        val btnEjecutar = findViewById<Button>(R.id.btnEjecutar)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btnCerrar = findViewById<ImageView>(R.id.btnCerrar)

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

        // Botón solucionar
        btnEjecutar.setOnClickListener {
            val input = edtTexto.text.toString().trim()
            val resultado = quitarFragmento(input)
            txtResultado.text = resultado
        }

        // Navegación inferior
        btnMitades.setOnClickListener {
            val intent = Intent(this, DosMitadesActivity::class.java)
            intent.putExtra("nombreUsuario", nombreUsuario)
            startActivity(intent)
        }

        btnPalabras.setOnClickListener {
            val intent = Intent(this, DosPalabrasActivity::class.java)
            intent.putExtra("nombreUsuario", nombreUsuario)
            startActivity(intent)
        }

        btnFragmento.setOnClickListener {
            Toast.makeText(this, "Ya estás en Quitar fragmento", Toast.LENGTH_SHORT).show()
        }
    }

    // Lógica del algoritmo "Quitar Fragmento"
    private fun quitarFragmento(cadena: String): String {
        val primeraH = cadena.indexOf('h')
        val ultimaH = cadena.lastIndexOf('h')

        return if (primeraH == -1 || ultimaH == -1 || primeraH == ultimaH) {
            "Error: Debe haber al menos dos letras 'h'"
        } else {
            cadena.removeRange(primeraH, ultimaH + 1)
        }
    }
}