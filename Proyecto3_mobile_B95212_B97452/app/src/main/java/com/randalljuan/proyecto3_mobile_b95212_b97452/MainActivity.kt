package com.randalljuan.proyecto3_mobile_b95212_b97452

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.randalljuan.proyecto3_mobile_b95212_b97452.Adapter.ModuleAdapter
import com.randalljuan.proyecto3_mobile_b95212_b97452.Models.Module
import com.randalljuan.proyecto3_mobile_b95212_b97452.databinding.ActivityMainBinding

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