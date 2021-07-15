package com.randalljuan.proyecto3_mobile_b95212_b97452

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.randalljuan.proyecto3_mobile_b95212_b97452.Adapter.ModuleAdapter
import com.randalljuan.proyecto3_mobile_b95212_b97452.Models.Module
import com.randalljuan.proyecto3_mobile_b95212_b97452.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    // get reference to the adapter class
    private var moduleList = ArrayList<Module>()
    private lateinit var rvAdapter: ModuleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // define layout manager for the Recycler view
        binding.rvList.layoutManager = LinearLayoutManager(this)
        // attach adapter to the recycler view and also handle item click
        // add adapter to the recycler view

        rvAdapter = ModuleAdapter(moduleList)

        binding.rvList.adapter = rvAdapter

        // create objects of Language
        // create some row data
        val gestModule= Module("Gestión de datos")
        val appointmentModule= Module("Citas")
        val vaccineModule= Module("Vacunas")
        val allergiesModule= Module("Alergias")

        // pass raw data t rhe list
        moduleList.add(gestModule)
        moduleList.add(appointmentModule)
        moduleList.add(vaccineModule)
        moduleList.add(allergiesModule)


        rvAdapter.notifyDataSetChanged()
    }

    // on destroy of view make the binding reference to null
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}