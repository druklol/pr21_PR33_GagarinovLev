package com.example.pr21_pr_33_gagarinovlev

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.navigation.Navigation

class CrimeFragment : Fragment() {
    private lateinit var crime: Crime
    private lateinit var title_ed: EditText
    private lateinit var date_btn: Button
    private lateinit var solved_cb: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        crime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)
        title_ed = view.findViewById(R.id.title_ed)
        date_btn = view.findViewById(R.id.date_btn)
        solved_cb = view.findViewById(R.id.solved_cb)

        date_btn.apply {
            text = crime.date.toString()
            isEnabled = false
        }
        return view
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                crime.title = p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        }

        title_ed.addTextChangedListener(titleWatcher)

        solved_cb.apply {
            setOnCheckedChangeListener { _, isChecked ->
                crime.isSolved = isChecked

                if (isChecked) {
                    val message = getString(R.string.crime_succes)
                    showSnackbar(message)
                    navigateToNextFragment()
                }
            }
        }
    }

    private fun showSnackbar(message: String) {
        view?.let { Snackbar.make(it, message, Snackbar.LENGTH_LONG).show() }
    }

    private fun navigateToNextFragment(){
        view?.let { Navigation.findNavController(it).navigate(R.id.action_FirstFragment_to_fragment_solved_crime) }
    }
}