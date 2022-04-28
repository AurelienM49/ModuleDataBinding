package com.eni.mod9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        thread{
            AppDB.get(this).animalDAO()
                .insert(Animal(0, "chien trop mignon", "Charlie", 15))
        }
    }
}