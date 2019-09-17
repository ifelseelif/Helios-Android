package com.example.ifelseelif.helios.db.pojo

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Person")
data class Person(

    @PrimaryKey(autoGenerate = true)
    var id : Int,

    @SerializedName("access_token")
    @ColumnInfo(name = "access_token")
    var accessToken: String,

    @SerializedName("refresh_token")
    @ColumnInfo(name = "refresh_token")
    var refreshToken: String
)