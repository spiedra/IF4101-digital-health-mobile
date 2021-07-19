package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.service.LogInService
import org.json.JSONObject
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var btnLogIn : Button
    private lateinit var btnSignUp: Button
    private lateinit var tvIdCard: TextView
    private lateinit var tvPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.btnLogIn = findViewById(R.id.btn_login)
        this.btnSignUp = findViewById(R.id.btn_sign_up)
        this.setOnClickListeners(btnLogIn)
        this.setOnClickListeners(btnSignUp)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_login -> {
                this.tvIdCard = findViewById(R.id.tv_id_card)
                this.tvPassword = findViewById(R.id.tv_password)
                Toast.makeText(this, LogInService().checksCredentials(createRequestBody(
                    "1-1818-0555", "admin")
                ), Toast.LENGTH_SHORT).show()
            }
            R.id.btn_sign_up -> {
                Toast.makeText(this, "Sign in button has been pressed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    val setOnClickListeners: (Button) -> Unit = { btn: Button -> btn.setOnClickListener(this)}

    val createRequestBody: (String, String) -> RequestBody = {idCard: String, password: String ->
        val jsonObject = JSONObject()
        jsonObject.put("name", idCard)
        jsonObject.put("salary", password)
        jsonObject.toString().toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
    }
}