package com.eni.navigationmod5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController

class ConnexionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_connexion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var btn = view.findViewById<Button>(R.id.button)
        val moi = User("aurel@aurel.com", 23)
        btn.setOnClickListener {
            val actionToHome = ConnexionFragmentDirections
                .actionConnexionFragmentToHomeFragment(
                moi
            )
            it.findNavController().navigate(actionToHome)
        }
    }
}
