package com.example.syncdemo.helpers

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.example.syncdemo.MainApplication
import com.example.syncdemo.database.FibRequestRoomDatabase
import com.example.syncdemo.database.models.FibRequest

class DBHelper() {
    private val fibRequestDao = FibRequestRoomDatabase.getDatabase(MainApplication.instance.applicationContext).fibRequestDao()

    fun getAllFibRequests(): MutableList<FibRequest>{
        return fibRequestDao.getAllFibRequests()
    }

    fun getFibRequestByID(id:Long): FibRequest?{
        return fibRequestDao.getFibRequestByID(id)
    }

    fun addFibRequest(request: FibRequest){
        fibRequestDao.addFibRequest(request)
    }

    fun deleteFibRequest(id:Long){
        fibRequestDao.deleteRequest(id)
    }

}