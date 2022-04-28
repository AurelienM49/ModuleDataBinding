package com.eni.modnavapi

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Creation d'un client
        val client = OkHttpClient()

        //Création d'une requête
        val google = Request.Builder()
            .url("https://swapi.dev/api/people/1")
            .build()
        //Execution de notre requête
        client.newCall(google).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("erreur")
            }

            override fun onResponse(call: Call, response: Response) {
                Log.i(TAG, "OnResponse: ${response.body?.string()}")
                  val peopleJson = JSONObject(response.body?.string())
                val people = People(
                    peopleJson["name"].toString(),
                    peopleJson["height"].toString(),
                    peopleJson["mass"].toString(),
                    peopleJson["eye_color"].toString(),
                    peopleJson["gender"].toString(),
                )
                Log.i(TAG, "Le personnage ${people.name}, " +
                        "mesure ${people.height}, " +
                        "et pèse ${people.mass}, " +
                        "a les yeux ${people.eye_color}, et du sexe ${people.gender}"
                )
            }
        })
    }
}