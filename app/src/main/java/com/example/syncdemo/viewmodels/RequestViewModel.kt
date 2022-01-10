package com.example.syncdemo.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.syncdemo.database.models.FibRequest
import com.example.syncdemo.helpers.DBHelper

class RequestViewModel() : ViewModel() {
    var fibSequence: MutableList<Int> = mutableListOf()
    var fibDisplayedList: MutableList<Int> = mutableListOf()

}