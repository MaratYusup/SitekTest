package com.example.mobileclient.data.network.model

import com.google.gson.annotations.SerializedName

data class UserAuthDto (
    @SerializedName("Authentication")
    var authentication: UserAuthDataModelDto?,
)