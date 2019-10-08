package com.example.passingdatatofragmentfromdialog

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment(), MyCustomDialog.OnInputListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mainFragment = inflater.inflate(R.layout.fragment_main, container, false)
        mainFragment.open_dialog.setOnClickListener {
            val dialog = MyCustomDialog()
            dialog?.setTargetFragment(this, 22)
            fragmentManager?.let { it -> dialog?.show(it, "MyCustomDialog") }
        }
        return mainFragment
    }

    override fun sendInput(input: String) {
        val mInputDisplay: TextView = input_display
        mInputDisplay.text = input
    }

}
