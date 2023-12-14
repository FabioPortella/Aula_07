package com.example.camera_a07ex08

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var btnCapturar: Button
    lateinit var imgFoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCapturar = findViewById(R.id.btnCapturar)
        imgFoto = findViewById(R.id.imgFoto)
    }

    // objeto de registro do evento de tirar foto
    val register = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {
        image: Bitmap? ->
        if (image != null) {
            imgFoto.setImageBitmap(image)
            exibirSnackbar("Foto adicionada com sucesso!")
        }

    }

    fun capturarFoto(view: View) {
        register.launch(null)
    }

    private fun exibirSnackbar(mensagem: String) {
        Snackbar.make(findViewById(android.R.id.content), mensagem, Snackbar.LENGTH_SHORT).show()
    }

    // alteração de código:
    // foi acicionado uma função que mostra uma SnackBar com a mensagem
    // "Foto adicionada com sucesso logo após encerrar a câmera fotográfica.
}