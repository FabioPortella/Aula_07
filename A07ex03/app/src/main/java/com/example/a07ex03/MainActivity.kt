package com.example.a07ex03

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var navegador = findViewById<FloatingActionButton>(R.id.fabNavegador)
        var telefone = findViewById<FloatingActionButton>(R.id.fabTelefone)
        var mensagem = findViewById<FloatingActionButton>(R.id.fabMensagem)
        var email = findViewById<FloatingActionButton>(R.id.fabEmail)

        navegador.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            startActivity(intent)
        }

        telefone.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:17981813030"))
            startActivity(intent)
        }

        mensagem.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:17981813030"))
            startActivity(intent)
        }

        email.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("mailto:")
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("email@dominio.com", "outroemail@dominio.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Assunto do email");
            intent.putExtra(Intent.EXTRA_TEXT, "Corpo da Mensagem");
            startActivity(intent)
        }

        // Não houve alteração de código, pois o APP foi montado pelo aluno, através
        // de orientação minima de código dos slides.
    }
}