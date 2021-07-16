package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.randalljuan.proyecto3_mobile_b95212_b97452.R

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewMenu();
    }

    fun viewMenu() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }
}