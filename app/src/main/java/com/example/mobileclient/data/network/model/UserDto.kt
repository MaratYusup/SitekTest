package com.example.mobileclient.data.network.model

import com.google.gson.annotations.SerializedName

data class UserDto (
    @SerializedName("Users")
    var users: UserDataListDto?
)