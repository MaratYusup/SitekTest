package com.example.mobileclient.data.network.model

import com.google.gson.annotations.SerializedName

data class UserDataListDto (
    @SerializedName("ListUsers")
    var listUsers: List<UserDataDto?>?
)