package edu.udb.ejemplogooglemaps1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolygonOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Agrega un marcador en la ubicación indicada
        val myPlace = LatLng(13.71610152141688, -89.1536665170907)
        mMap.addMarker(MarkerOptions().position(myPlace).title("UDB-100"))

        // Mueve la cámara a la ubicación del marcador y aplica un zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myPlace, 15f))

        // Agrega un polígono con algunas coordenadas
        val polygonOptions = PolygonOptions()
            .add(LatLng(13.716160,-89.153555))
            .add(LatLng(13.716135,-89.153803))
            .add(LatLng(13.715880,-89.153800))
            .add(LatLng(13.715886,-89.153563))
            .strokeColor(Color.RED)
            .fillColor(Color.BLUE)
        mMap.addPolygon(polygonOptions)
    }
}
