package com.example.pr21_pr_33_gagarinovlev

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class Fragment_solved_crime : Fragment() {
    private lateinit var back_btn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_solved_crime, container, false)
        back_btn = view.findViewById(R.id.back_btn)
        back_btn.setOnClickListener {
            navigateToNextFragment()
        }
        return view
    }

    private fun navigateToNextFragment(){
        view?.let { Navigation.findNavController(it).navigate(R.id.action_fragment_solved_crime_to_FirstFragment) }
    }
}