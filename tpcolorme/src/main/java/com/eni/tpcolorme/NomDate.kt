package com.eni.tpcolorme

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.navigation.Navigation
import java.util.*


class NomDate : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nom_date, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn = view.findViewById<Button>(R.id.validerNomDate)

        btn.setOnClickListener {
            val date = view.findViewById<EditText>(R.id.date).hashCode()
            Log.d("Date", date.toString())
            val nom = view.findViewById<EditText>(R.id.nom2).hashCode()

            if (date + nom > 0) {
                Navigation.findNavController(view).navigate(
                    R.id.action_nomDate_to_orangeFragment
                )
            } else {
                Navigation.findNavController(view).navigate(
                    R.id.action_nomDate_to_bleuFragment
                )
            }
        }
    }
}