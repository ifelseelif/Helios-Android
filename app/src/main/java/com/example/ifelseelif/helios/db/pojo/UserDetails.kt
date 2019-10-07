package com.example.ifelseelif.helios.db.pojo

import android.arch.persistence.room.Entity
import com.example.ifelseelif.helios.db.pojo.userDetails.Queue
import com.example.ifelseelif.helios.db.pojo.userDetails.SwapRequest
import com.example.ifelseelif.helios.db.pojo.userDetails.User
import com.google.gson.annotations.SerializedName

@Entity(tableName = "User")
class UserDetails (

    @SerializedName("queues")
    val queues : List<Queue>,

    @SerializedName("queues_member")
    val queuesMember : List<Queue>,


    @SerializedName("swap_requests_in")
    val swapRequestIn : List<SwapRequest>,

    @SerializedName("swap_requests_out")
    val swapRequestOut : List<SwapRequest>,

    @SerializedName("user")
    val user : User
)