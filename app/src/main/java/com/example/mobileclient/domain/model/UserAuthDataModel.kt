package com.example.mobileclient.domain.model

import androidx.room.ColumnInfo

data class UserAuthDataModel (
    var user: String? = "",
    var uid: String? = "",
    var response: Boolean? = false,
    var continueWork: Boolean? = false,
    var photoHash: String? = "",
    var currentDate: String? = "",
)