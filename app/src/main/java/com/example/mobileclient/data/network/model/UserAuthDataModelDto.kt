package com.example.mobileclient.data.network.model


import com.google.gson.annotations.SerializedName

data class UserAuthDataModelDto (
    @SerializedName("Response")
    var response: Boolean? = false,

    @SerializedName("ContinueWork")
    var continueWork: Boolean? = false,

    @SerializedName("PhotoHash")
    var photoHash: String? = "",

    @SerializedName("CurrentDate")
    var currentDate: String? = "",
)
