package com.example.a07ex05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imgFoto)
        Glide.with(this)
            .load("http://pudim.com.br/pudim.jpg")
            .into(imageView)
    }

    // Alteração do código:
    // inseri um TextView com a mensagem "Minha nova imagem".
}