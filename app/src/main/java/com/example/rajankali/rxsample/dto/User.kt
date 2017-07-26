package com.example.rajankali.rxsample.dto
import com.google.gson.annotations.SerializedName

/**
 * Created by rajan.kali on 7/25/2017.
 * Kotlin data class - Movie
 */
data class User(@SerializedName("id") val id:Int,
                @SerializedName("first_name") val firstName : String,
                @SerializedName("last_name") val lastName : String,
                @SerializedName("avatar") val avatar : String
                ): BaseModel()

data class UserResponse(@SerializedName("page") val page : Int,
                        @SerializedName("per_page") val perPage: Int,
                        @SerializedName("total") val total:Int,
                        @SerializedName("total_pages") val totalPages:Int,
                        @SerializedName("data") val users: List<User>)
