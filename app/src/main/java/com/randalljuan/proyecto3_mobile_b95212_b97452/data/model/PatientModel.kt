package com.randalljuan.proyecto3_mobile_b95212_b97452.data.model

import com.google.gson.annotations.SerializedName

data class PatientModel(
    @SerializedName("idCard")
    val idCard: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("age")
    val age: Int?,
    @SerializedName("bloodType")
    val bloodType: String?,
    @SerializedName("civilStatus")
    val civilStatus: String?,
    @SerializedName("address")
    val address: String?,
    @SerializedName("phoneNumber1")
    val phoneNumber1: String?,
    @SerializedName("phoneNumber2")
    val phoneNumber2: Any? = null
)
