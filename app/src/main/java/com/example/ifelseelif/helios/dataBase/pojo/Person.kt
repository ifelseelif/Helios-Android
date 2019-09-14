package com.example.ifelseelif.helios.dataBase.pojo

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Person")
class Person(

    @PrimaryKey(autoGenerate = true)
    var id : Int,

    @ColumnInfo(name = "access_token")
    var accesToken : String,

    @ColumnInfo(name = "access_token")
    var refreshToken : String
)