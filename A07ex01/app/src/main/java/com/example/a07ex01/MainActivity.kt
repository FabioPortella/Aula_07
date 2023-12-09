package com.example.a07ex01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // cria um objeto representando o layout da tela
        var meuLayout = findViewById<ConstraintLayout>(R.id.meuLayout)
        // define um evento ao clicar no layout (qualquer parte da tela)
        meuLayout.setOnClickListener { view ->
            // cria um objeto que representa o TextView da tela
            var rotulo = findViewById<TextView>(R.id.textView)
            // mostra um Snackbar com um botão de fechar
            var s = Snackbar.make(view, "Tudo bem?  ${rotulo.text}", Snackbar.LENGTH_INDEFINITE)
            s.setAction("Fechar", { s.dismiss() }) // define a ação de fechar
            s.show()
        }
    }
}

// Alteração de código:
// linha 21 - acrescentou um "Tudo bem" antes do ródulo.