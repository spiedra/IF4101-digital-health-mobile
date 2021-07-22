package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.randalljuan.proyecto3_mobile_b95212_b97452.R

class AllergyDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allergy_details)

        val parameters = this.intent.extras
        if (parameters != null) {
            (findViewById<TextView>(R.id.tvAlergyType)).text = parameters.getString("AllergyType")
            (findViewById<TextView>(R.id.tvHealthCenter)).text = parameters.getString("DiagnosticDate")
            (findViewById<TextView>(R.id.tvDescriptionAllergy)).text = parameters.getString("Description")
        }
    }
}