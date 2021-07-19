package com.randalljuan.proyecto3_mobile_b95212_b97452.data.model

import com.google.gson.annotations.SerializedName

data class PatientModel(
    @SerializedName("idCard")
    val idCard: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("age")
    val age: Int? = null,
    @SerializedName("bloodType")
    val bloodType: String? = null,
    @SerializedName("civilStatus")
    val civilStatus: String? = null,
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("phoneNumber1")
    val phoneNumber1: String? = null,
    @SerializedName("phoneNumber2")
    val phoneNumber2: String? = null
)
