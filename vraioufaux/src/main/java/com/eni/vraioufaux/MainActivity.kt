package com.eni.vraioufaux

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.eni.vraioufaux.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var amb: ActivityMainBinding
    var cpt = 0;
    var index = 0
    var question = findViewById<TextView>(R.id.question)
    val q1 = Questionnaire(" Le béret est d’origine basque", false)
    val q2 = Questionnaire("Paris est la capital de la France", true)
    val q3 = Questionnaire("La société coca-cola a crée l'image du Père Nöel", false)
    val q4 = Questionnaire("Le coeur d'une crevette est logé dans sa tête", false)
    val tabQuestion = arrayOf(q1, q2, q3, q4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //j'initialise le score à 0
        amb.compteur.text = "${cpt}/${tabQuestion.size} points"

        //j'affiche la première question
        question.text = tabQuestion[index].question;
        //si il clique sur vrai
        amb.vrai.setOnClickListener { reponseUser(true) }
        //si il clique sur faux
        amb.faux.setOnClickListener { reponseUser(false) }


    }

    fun reponseUser(reponseUser: Boolean) {
        if (reponseUser == tabQuestion[index].reponse) {
            cpt++;
            amb.compteur.text = "${cpt}/${tabQuestion.size} points"
        }
        //on est rendu au bout du tab
        if (index == tabQuestion.size - 1) {
            amb.vrai.isEnabled = false
            amb.faux.isEnabled = false
            if(cpt > 2){
                question.text = "Bravo !"
            }else{
                question.text = "Nul !"
            }
        } else {
            //on passe à la question suivante et on l'affiche
            index++;
            question.text = tabQuestion[index].question;
        }
    }
}