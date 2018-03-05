package com.coskun.dagger2training.extension

import android.util.Log

/**
 * Created by Coskun Yalcinkaya.
 */

fun Any.logDebug(any: Any){
    Log.d("Dagger2TrainingApp ${this.javaClass.simpleName}", any.toString())
}