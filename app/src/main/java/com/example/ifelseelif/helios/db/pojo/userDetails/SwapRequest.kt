package com.example.ifelseelif.helios.db.pojo.userDetails

import android.arch.persistence.room.ColumnInfo
import com.google.gson.annotations.SerializedName

class SwapRequest (

    @SerializedName("queue_name")
    @ColumnInfo(name = "queue_name")
    val name : String,

    @SerializedName("firstname")
    @ColumnInfo(name = "firstname")
    val firstName : String,

    @SerializedName("lastname")
    @ColumnInfo(name = "lastname")
    val lastname : String,

    @SerializedName("queue_fullname")
    @ColumnInfo(name = "queue_fullname")
    val queue_fullname : String,

    @SerializedName("username")
    @ColumnInfo(name = "username")
    val username: String
)