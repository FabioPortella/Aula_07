package com.example.a07ex06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var r = findViewById<RecyclerView>(R.id.rv)
        r.layoutManager = LinearLayoutManager(this)

        // definindo o array de produtos
        var arr = ArrayList<Produto>()

        // código alterado

        arr.add(Produto(android.R.drawable.ic_media_play, "Mini Player", "Xing Ling", "R$ 120,00"))
        arr.add(Produto(android.R.drawable.ic_menu_camera, "Câmera AS 50", "Canon", "R$ 1.200,00"))
        arr.add(Produto(android.R.drawable.ic_menu_call, "Celular S20E",  "Samsung","R$ 1.500,00"))
        arr.add(Produto(android.R.drawable.ic_menu_camera, "Câmera AS 100", "Canon", "R$ 1.800,00"))
        // adicionando os demais produtos fictícios de 5 a 30
        for (i in 5 .. 30)
            arr.add(Produto(android.R.drawable.ic_menu_edit,"Produto $i", "Marca","R$ $i,99"))
        // definindo o adapter
        var adapter = CustomAdapter(arr)
        r.adapter = adapter
    }

    // Alteração de código - foi adicionado Marca.
    // os campos agora são: Imagem, Titulo, Marca e Valor
    // procedi algumas alterações em produto e Layout para que
    // o campo valor não aparecesse mais como "descrição" no código.
}