package com.example.rajankali.rxsample.util

import android.content.Context
import android.util.Log
import android.widget.Toast

/**
 * Created by rajan.kali on 7/21/2017.
 * Extension methods for UI
 */

fun Context.longToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
}

fun Context.shortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
}

fun log(message:String){
    Log.d("RxSample",message)
}


