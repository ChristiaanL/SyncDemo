package com.example.syncdemo.database.data_access

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.syncdemo.database.models.FibRequest

@Dao
interface FibRequestDao{
    @Query("SELECT * FROM FibRequest ORDER BY requestTime ASC")
    fun getAllFibRequests(): MutableList<FibRequest>

    @Query("SELECT * FROM FibRequest WHERE id=:requestID LIMIT 1")
    fun getFibRequestByID(requestID: Long): FibRequest?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addFibRequest(request: FibRequest)

    @Query("DELETE FROM FibRequest WHERE id=:requestID")
    fun deleteRequest(requestID: Long)
}