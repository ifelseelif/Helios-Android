package com.example.ifelseelif.helios.db.pojo.userDetails

import android.arch.persistence.room.ColumnInfo
import com.google.gson.annotations.SerializedName

class User(

    @SerializedName("contact_details")
    @ColumnInfo(name = "contact_details")
    val contactDetails : ContactDetails,

    @SerializedName("first_name")
    @ColumnInfo(name = "first_name")
    val firstName : String,

    @SerializedName("id")
    @ColumnInfo(name = "id")
    val id : Int,

    @SerializedName("last_name")
    @ColumnInfo(name = "last_name")
    val lastName : String,

    @SerializedName("user_type")
    @ColumnInfo(name = "user_type")
    val userType : String,

    @SerializedName("username")
    @ColumnInfo(name = "username")
    val username : String
)