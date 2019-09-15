package com.example.ifelseelif.helios.dataBase.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Person")
data class Person(

    @SerializedName("access_token")
    @ColumnInfo(name = "access_token")
    var accessToken : String,

    @SerializedName("refresh_token")
    @ColumnInfo(name = "refresh_token")
    var refreshToken : String
)