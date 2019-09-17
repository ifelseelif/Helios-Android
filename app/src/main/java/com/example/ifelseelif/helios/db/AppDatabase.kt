package com.example.ifelseelif.helios.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.ifelseelif.helios.db.pojo.Person

@Database(entities = arrayOf(Person::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPersonDao(): PersonDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "roomdb")
                    .build()
            }
            return INSTANCE as AppDatabase
        }
    }
}