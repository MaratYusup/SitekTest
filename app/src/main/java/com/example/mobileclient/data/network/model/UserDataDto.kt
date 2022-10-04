package com.example.mobileclient.data.network.model

import com.google.gson.annotations.SerializedName

data class UserDataDto(
    @SerializedName("User")
    var user: String?,

    @SerializedName("Uid")
    var uid: String?,

    @SerializedName("Language")
    var language: String?,
)