package com.example.mobileclient.domain.model

import com.google.gson.annotations.SerializedName

data class UserData (
    var responseCode: Int? = -1,
    var user: String? = "",
    var uid: String? = "",
    var language: String? = "",
) {
    override fun toString(): String {
        return user ?: ""
    }
}