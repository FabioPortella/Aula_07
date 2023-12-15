package com.example.a07ex11e12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var map: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        map = findViewById<MapView>(R.id.mapView)
        map.onCreate((savedInstanceState))
        map.getMapAsync(this)

        val btnCasa = findViewById<Button>(R.id.btnCasa)
        btnCasa.setOnClickListener {
            moveCamera(LatLng(-20.5716, -48.5706))
        }
        val btnTrabalho = findViewById<Button>(R.id.btnTrabalho)
        btnTrabalho.setOnClickListener {
            moveCamera(LatLng(-20.5741, -48.5588))
        }
        val btnEscola = findViewById<Button>(R.id.btnEscola)
        btnEscola.setOnClickListener {
            moveCamera(LatLng(-20.541893, -48.548993))
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val ifsp = LatLng(-20.541893, -48.548993)
        val house = LatLng(-20.5716, -48.5706)
        val trabalho = LatLng(-20.5741, -48.5588)

        mMap.addMarker(MarkerOptions().position(ifsp).title("Marker in IFSP"))
        mMap.addMarker(MarkerOptions().position(house).title("Marker in My House"))
        mMap.addMarker(MarkerOptions().position(trabalho).title("Marker in Trabalho"))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(trabalho))

        mMap.setMinZoomPreference(15f)
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    private fun moveCamera(location: LatLng) {
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location))
    }

    // Não houve alteração de código,
    // sendo o sistema desenvolvido pelo aluno.
}