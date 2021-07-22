package com.randalljuan.proyecto3_mobile_b95212_b97452.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.randalljuan.proyecto3_mobile_b95212_b97452.R
import com.randalljuan.proyecto3_mobile_b95212_b97452.data.service.PatientService
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnConfirm: Button
    private lateinit var tvIdCard: TextView
    private lateinit var tvName: TextView
    private lateinit var tvLastName: TextView
    private lateinit var tvPassword: TextView
    private lateinit var tvAge: TextView
    private lateinit var spiBloodType: Spinner
    private lateinit var tvCivilStatus: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvPhoneNumber1: TextView
    private lateinit var tvPhoneNumber2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        this.btnConfirm = findViewById(R.id.btn_confirm)
        this.setOnClickListeners(btnConfirm)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_confirm -> {
                tvIdCard = findViewById(R.id.editTextSignUpIdCard)
                tvName = findViewById(R.id.editTextName)
                tvLastName = findViewById(R.id.editTextLastName)
                tvPassword = findViewById(R.id.editTextTextPassword)
                tvAge = findViewById(R.id.editTextAge)
                spiBloodType = findViewById(R.id.spinnerBloodType)
                tvCivilStatus = findViewById(R.id.editTextCivilStatus)
                tvAddress = findViewById(R.id.editTextAddress)
                tvPhoneNumber1 = findViewById(R.id.editTextPhone1)
                tvPhoneNumber2 = findViewById(R.id.editTextPhone2)

                PatientService().signUp(
                    createRequestBody(
                        tvIdCard.text.toString(),
                        tvName.text.toString(),
                        tvLastName.text.toString(),
                        tvPassword.text.toString(),
                        Integer.parseInt(tvAge.text.toString()),
                        spiBloodType.selectedItem.toString(),
                        tvCivilStatus.text.toString(),
                        tvAddress.text.toString(),
                        tvPhoneNumber1.text.toString(),
                        tvPhoneNumber2.text.toString(),
                    ), this
                )
            }
        }
    }

    val setOnClickListeners: (Button) -> Unit = { btn: Button -> btn.setOnClickListener(this) }

    val createRequestBody: (String, String, String, String, Int, String, String, String, String, String) -> RequestBody =
        { idCard: String, name: String, lastName: String, password: String, age: Int, bloodType: String, civilStatus: String, address: String, phoneNumber1: String, phoneNumber2: String ->
            val jsonObject = JSONObject()
            jsonObject.put("idCard", idCard)
            jsonObject.put("name", name)
            jsonObject.put("lastName", lastName)
            jsonObject.put("password", password)
            jsonObject.put("age", age)
            jsonObject.put("bloodType", bloodType)
            jsonObject.put("civilStatus", civilStatus)
            jsonObject.put("address", address)
            jsonObject.put("phoneNumber1", phoneNumber1)
            jsonObject.put("phoneNumber2", phoneNumber2)
            jsonObject.toString()
                .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
        }
}