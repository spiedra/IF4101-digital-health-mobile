package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.service.LoginService
import com.randalljuan.proyecto3_mobile_b95212_b97452.utility.SessionManager
import com.randalljuan.proyecto3_mobile_b95212_b97452.utility.Utils
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.json.JSONObject
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnLogIn: Button
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
                tvIdCard = findViewById(R.id.tv_id_card)
                tvPassword = findViewById(R.id.tv_password)
                SessionManager.setIdCard(tvIdCard.text.toString())
                LoginService().validatePatientLogIn(
                    createRequestBody(
                        tvIdCard.text.toString(),
                        tvPassword.text.toString()
                    ), this
                )
            }
            R.id.btn_sign_up -> {
               Utils.startActivity(this, SignUpActivity::class.java)
            }
        }
    }

    val setOnClickListeners: (Button) -> Unit = { btn: Button -> btn.setOnClickListener(this) }

    val createRequestBody: (String, String) -> RequestBody = {idCard: String, password: String ->
        val jsonObject = JSONObject()
        jsonObject.put("idCard", idCard)
        jsonObject.put("name", null)
        jsonObject.put("lastName", null)
        jsonObject.put("password", password)
        jsonObject.put("age", null)
        jsonObject.put("bloodType", null)
        jsonObject.put("civilStatus", null)
        jsonObject.put("address", null)
        jsonObject.put("phoneNumber1", null)
        jsonObject.put("phoneNumber2", null)
        jsonObject.toString().toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
    }
}
