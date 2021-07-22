package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.randalljuan.proyecto3_mobile_b95212_b97452.R

class GestionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var cvShowPersonalInfo: CardView
    private lateinit var cvUpdatePersonalInfo: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion)

        cvShowPersonalInfo = findViewById(R.id.cvShowInfo)
        cvUpdatePersonalInfo = findViewById(R.id.cvUpdateInfo)
        this.setOnClickListeners(cvShowPersonalInfo)
        this.setOnClickListeners(cvUpdatePersonalInfo)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.cvShowInfo -> {
                val intent = Intent(this, ShowPersonallnfoActivity::class.java)
                startActivity(intent)
            }
            R.id.cvUpdateInfo -> {
                val intent = Intent(this, UpdatePersonalInfoActivity::class.java)
                startActivity(intent)
            }
        }
    }

    val setOnClickListeners: (CardView) -> Unit = { cv: CardView -> cv.setOnClickListener(this) }
}