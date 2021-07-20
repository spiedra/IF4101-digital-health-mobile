package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.randalljuan.proyecto3_mobile_b95212_b97452.R

class VaccineDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine_details)

        val parameters = this.intent.extras
        if (parameters != null) {
            val vaccineType = parameters.getString("VaccineType")
            val latestDate= parameters.getString("LatestDate")
            val nextDate= parameters.getString("NextDate")
            val description= parameters.getString("Description")

            
        }
    }
}