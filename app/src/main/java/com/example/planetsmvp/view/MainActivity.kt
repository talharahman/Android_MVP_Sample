package com.example.planetsmvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.planetsmvp.R
import com.example.planetsmvp.view.DisplayFragment.Companion.newInstance

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, newInstance())
                .commit()
    }
}