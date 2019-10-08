package com.example.passingdatatofragmentfromdialog

import android.content.Context
import android.net.Uri
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_my_custom.view.*


class MyCustomDialog : DialogFragment() {

    interface OnInputListener {
        fun sendInput(input: String)
    }

    var onInputListener: OnInputListener? = null

    val TAG: String = "MyCustomDialog"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val customDialog = inflater.inflate(R.layout.dialog_my_custom, container, false)


        customDialog.action_ok.setOnClickListener {
            val inputText: String = customDialog.input.text.toString()
            onInputListener?.sendInput(inputText)
            dismiss()
        }
        return customDialog
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            onInputListener = targetFragment as OnInputListener?
            d(TAG, "onAttach: $onInputListener")
        } catch (e: ClassCastException) {
            d(TAG, "onAttach: ClassCastException : " + e.message)
        }
    }


}
