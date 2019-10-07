package com.example.ifelseelif.helios.db.pojo.userDetails

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "queues")
data class Queue (

    @SerializedName("short_name")
    @ColumnInfo(name = "short_name")
    val name : String,

    @SerializedName("fullname")
    @ColumnInfo(name = "fullname")
    val fullName : String
)