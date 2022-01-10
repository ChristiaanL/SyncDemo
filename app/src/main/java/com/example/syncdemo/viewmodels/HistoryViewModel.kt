package com.example.syncdemo.viewmodels

import androidx.lifecycle.ViewModel
import com.example.syncdemo.database.models.FibRequest

class HistoryViewModel: ViewModel(){
    var historyList :MutableList<FibRequest> = mutableListOf()
}