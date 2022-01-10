package com.example.syncdemo.database.models
import androidx.room.*

@Entity
class FibRequest (

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    var value: Int,
    var requestTime: Int,

)