package com.example.ifelseelif.helios.db.pojo.userDetails

import android.arch.persistence.room.ColumnInfo
import com.google.gson.annotations.SerializedName

class ContactDetails (
    @SerializedName("email")
    @ColumnInfo(name = "email")
    val email : String,

    @SerializedName("img")
    @ColumnInfo(name = "img")
    val img : String,

    @SerializedName("vkontakteId")
    @ColumnInfo(name = "vkontakteId")
    val vkontakteId : Int
)