package com.example.qr_code_a07ex09

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage

class MainActivity : AppCompatActivity() {

    lateinit var btnCapturar: Button
    lateinit var imgFoto: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCapturar = findViewById((R.id.btnCapturar))
        imgFoto = findViewById(R.id.imgFoto)
    }

    val register = registerForActivityResult(
        ActivityResultContracts.TakePicturePreview()
    ) { image: Bitmap? ->
        imgFoto.setImageBitmap(image)

        val scanner = BarcodeScanning.getClient()
        val bitmap = InputImage.fromBitmap(image!!, 0)
        val result = scanner.process(bitmap)
            .addOnSuccessListener { barcodes ->
            for (barcode in barcodes) {
                val valueType = barcode.valueType
                when (valueType) {
                    Barcode.TYPE_URL -> {
                        val url = barcode.url!!.url
                        findViewById<TextView>(R.id.txtResultado).text = url.toString()

                        // código acrescentado - Executa o navegador com a URL obtida
                        val openUrlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url.toString()))
                        startActivity(openUrlIntent)
                    }
                }
            }
        }
            .addOnFailureListener { Log.e("=====>", it.printStackTrace().toString())
            }

    }

    fun capturaFotoQRCode(view: View) {
        register.launch(null) // disparar o evento registrado
    }

    // foi implementado o PLUS do slide 56,
    // código das linhaws 50 e 51, 
    // executa o navegador com a URL obtida.

}