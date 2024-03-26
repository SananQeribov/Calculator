package com.example.hesabmakinesi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Calculator : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String>
        get() = _result

    fun inputnumber (number: String){
        val currentResult = ""

  var  updatedResult =  currentResult + number
        _result.value = updatedResult


    }

    fun clear(a:String): Pair<String,String> {

        _result.value = "0"
        val b = ""

        return  Pair(_result.value.toString(),b)
    }


}