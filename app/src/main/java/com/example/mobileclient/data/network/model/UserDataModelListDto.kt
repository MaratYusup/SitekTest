package com.example.mobileclient.data.network.model

import com.google.gson.annotations.SerializedName

data class UserDataModelListDto (
    @SerializedName("ListUsers")
    var listUsers: List<UserDataModelDto?>?
)