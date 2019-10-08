package com.example.passingdatatofragmentfromdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = MainFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment, TAG)
        transaction.commit()

    }
}
