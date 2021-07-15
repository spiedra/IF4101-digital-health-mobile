package com.randalljuan.proyecto3_mobile_b95212_b97452

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.randalljuan.proyecto3_mobile_b95212_b97452.Adapter.ModuleAdapter
import com.randalljuan.proyecto3_mobile_b95212_b97452.Models.Module
import com.randalljuan.proyecto3_mobile_b95212_b97452.databinding.ActivityMainBinding
import com.randalljuan.proyecto3_mobile_b95212_b97452.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private var _binding: ActivityMenuBinding? = null
    private val binding get() = _binding!!


    private var moduleList = ArrayList<Module>()
    private lateinit var moduleAdapter: ModuleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        _binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.moduleList.layoutManager = LinearLayoutManager(this)
        moduleAdapter = ModuleAdapter(moduleList)
        binding.moduleList.adapter = moduleAdapter
        addModules();
    }

    fun addModules(){
        val gestModule= Module("Gestión de datos")
        val appointmentModule= Module("Citas")
        val vaccineModule= Module("Vacunas")
        val allergiesModule= Module("Alergias")
        moduleList.add(gestModule)
        moduleList.add(appointmentModule)
        moduleList.add(vaccineModule)
        moduleList.add(allergiesModule)
        moduleAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}