package com.eni.tpcolorme

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.eni.tpcolorme.databinding.ActivityMainBinding


class PrenomFragment : Fragment() {
    lateinit var amb: ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prenom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn = view.findViewById<Button>(R.id.btnPrenom)

        btn.setOnClickListener {
            val prenom = view.findViewById<EditText>(R.id.prenom).hashCode() / 1000000
            if (prenom > 665) {
                Navigation.findNavController(view).navigate(
                    R.id.action_prenomFragment_to_nomMot
                )
            } else {
                Navigation.findNavController(view).navigate(
                    R.id.action_prenomFragment_to_nomDate
                )
            }
        }

 /*       button.setOnClickListener(
            //Renvoie une instance de OnClickListener (et est déclenché par android lors du clic)
            Navigation.createNavigateOnClickListener(R.id.action_connexionFragment_to_homeFragment)
        )
        button.setOnClickListener {
            //Ici "{}" nous sommes dans la déclaration du OnClickListener
            // Nous déclenchons manuellement le navigate
            Navigation.findNavController(view).navigate(R.id.action_connexionFragment_to_homeFragment))
        }*/
        /*var btn = view.findViewById<Button>(R.id.button)
        btn.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_connexionFragment_to_homeFragment
            )
        )*/

    }


}