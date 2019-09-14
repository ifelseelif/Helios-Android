package com.example.ifelseelif.helios.dataBase


import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.ifelseelif.helios.dataBase.pojo.Person

@Dao
interface personDao {
    @Query("SELECT * FROM  Person")
    fun getInfo() : List<Person>
}