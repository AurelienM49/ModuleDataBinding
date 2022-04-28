package com.eni.mod10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.rvVoiture)
        val alVoiture = arrayListOf(
            Voiture("Tesla","Model S", 650,0f,"EL","fuchsia",""),
            Voiture("Tesla","Model 3", 650,0f,"EL","bleue",""),
            Voiture("Tesla","Model X", 650,0f,"EL","rose",""),
            Voiture("Tesla","Model Y", 650,0f,"EL","vert",""),
            Voiture("Hyundai","Ioniq 5", 650,0f,"EL","marron",""),
            Voiture("Kia","EV6", 650,0f,"EL","jaune",""),
            Voiture("Kia","eNiro", 650,0f,"EL","oui",""),
            Voiture("Hyundai","Kona", 650,0f,"EL","noire",""),
            Voiture("Peugeot","208", 80,1.0f,"ES","azure",""),
        )
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = VoitureAdapter(alVoiture)
    }
}