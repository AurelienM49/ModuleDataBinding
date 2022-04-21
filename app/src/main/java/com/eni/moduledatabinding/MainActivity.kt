package com.eni.moduledatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.eni.moduledatabinding.databinding.ActivityMainBinding
import io.github.serpro69.kfaker.faker
import io.github.serpro69.kfaker.fakerConfig

class MainActivity : AppCompatActivity() {
    lateinit var amb: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val manu : User = User("Macron", "Manu", "1977", "H")
        val valls : User = User("Valls", "Manu", "1962", "H")
        val elon : User = User("Musk", "Elon", "1971", "H")
        val sibeth : User = User("Ndiaye", "Sibeth", "1979", "F")

        val faker = faker{ fakerConfig { locale="fr" }}
        val user1 : User = User(faker.name.lastName(),
            faker.name.firstName(), (1900..2000).random().toString(),
            faker.gender.types())
        amb.user = manu

    }
}