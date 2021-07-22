package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.randalljuan.proyecto3_mobile_b95212_b97452.R

class VaccineDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine_details)

        val parameters = this.intent.extras
        if (parameters != null) {
            (findViewById<TextView>(R.id.tvSpecialty)).text = parameters.getString("VaccineType")
            (findViewById<TextView>(R.id.tvHealthCenter)).text = parameters.getString("LatestDate")
            (findViewById<TextView>(R.id.tvNextDate)).text = parameters.getString("NextDate")
            (findViewById<TextView>(R.id.tvDescriptionAllergy)).text = parameters.getString("Description")
        }
    }
}