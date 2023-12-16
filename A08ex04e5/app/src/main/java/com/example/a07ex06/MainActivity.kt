package com.example.a07ex06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.widget.ImageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // cria o objeto 'service', especificando a URL e a interface
        val service = Retrofit.Builder()
            .baseUrl("https://randomuser.me/") // URL usada
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(UserService::class.java) // nossa interface

        val r = findViewById<RecyclerView>(R.id.rv)
        r.layoutManager = LinearLayoutManager(this)

        // definindo o array de produtos
        val arr = ArrayList<Produto>()

        service.getUsers().enqueue(object : Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d("TAG_", "Houve um erro!")
                t.printStackTrace()
            }
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                // cria uma lista de usuários
                val users: List<User> = response.body()!!.results
                val imageView = findViewById<ImageView>(R.id.figura)

                  for (u in users) {
                      arr.add(Produto(
                          u.picture.thumbnail,
                          "${u.name.first} ${u.name.last}",
                          u.email,
                          u.phone
                      ))
                  }

                // definindo o adapter
                val adapter = CustomAdapter(arr)
                r.adapter = adapter
            }
        })
    }
}
// controller
data class UserResponse(val results: List<User>)

// models
data class User(val name: Name, val email: String, val phone: String, val picture: Picture)
data class Name(val title: String, val first: String, val last: String)
data class Picture(val large: String, val medium: String, val thumbnail: String)

// interface de mapeamento do WS
interface UserService {
    @GET("/api/?results=10")
    fun getUsers(): Call<UserResponse>
}

// Não teve alteração de código,
// app desenvolvido pelo aluno.