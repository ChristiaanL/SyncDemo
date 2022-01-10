package com.example.syncdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.syncdemo.database.data_access.FibRequestDao
import com.example.syncdemo.database.models.FibRequest

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(FibRequest::class), version = 1, exportSchema = false)
public abstract class FibRequestRoomDatabase : RoomDatabase() {

    abstract fun fibRequestDao(): FibRequestDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: FibRequestRoomDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): FibRequestRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FibRequestRoomDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}