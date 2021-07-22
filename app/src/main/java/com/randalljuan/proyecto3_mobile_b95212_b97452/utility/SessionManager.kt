package com.randalljuan.proyecto3_mobile_b95212_b97452.utility

object SessionManager {

    private lateinit var idCard: String

    fun setIdCard(currentIdCard: String) {
       idCard = currentIdCard
    }

    fun getIdCard(): String{
        return idCard
    }
}