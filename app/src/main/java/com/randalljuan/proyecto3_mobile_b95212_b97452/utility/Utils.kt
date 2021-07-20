package com.randalljuan.proyecto3_mobile_b95212_b97452.utility

import android.content.Context
import android.content.Intent
import android.widget.Toast

class Utils {
    companion object {
        fun startActivity(context: Context, clazz: Class<*>) {
            val intent = Intent(context, clazz)
            context.startActivity(intent)
        }

        fun showToast(context: Context, message: String){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}