package com.example.ifelseelif.helios.db


import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.ifelseelif.helios.db.pojo.Person

@Dao
interface PersonDao {
    @Query("SELECT * FROM  Person")
    fun getInfo() : List<Person>

    @Insert
    fun insert(person: Person)

    @Delete
    fun deleteAll(persons : List<Person>) : Int
}