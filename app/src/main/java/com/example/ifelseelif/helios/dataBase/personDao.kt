package com.example.ifelseelif.helios.dataBase


import androidx.room.Dao
import androidx.room.Query
import com.example.ifelseelif.helios.dataBase.pojo.Person

@Dao
interface personDao {
    @Query("SELECT * FROM  Person")
    fun getInfo() : List<Person>
}