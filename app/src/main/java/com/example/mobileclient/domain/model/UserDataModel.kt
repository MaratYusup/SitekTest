package com.example.mobileclient.domain.model

import com.google.gson.annotations.SerializedName

data class UserDataModel (
    var user: String? = "",
    var uid: String? = "",
    var language: String? = "",
) {
    override fun toString(): String {
        return user ?: ""
    }
}