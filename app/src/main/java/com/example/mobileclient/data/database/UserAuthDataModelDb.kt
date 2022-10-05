package com.example.mobileclient.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userAuthDbTable")
data class UserAuthDataModelDb (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userAuth_id")
    var id: Long = 0,

    @ColumnInfo(name = "userAuth_user")
    var user: String? = "",

    @ColumnInfo(name = "userAuth_uid")
    var uid: String? = "",

    @ColumnInfo(name = "userAuth_response")
    var response: Boolean? = false,

    @ColumnInfo(name = "userAuth_continue_work")
    var continueWork: Boolean? = false,

    @ColumnInfo(name = "userAuth_photo_hash")
    var photoHash: String? = "",

    @ColumnInfo(name = "userAuth_current_date")
    var currentDate: String? = "",
)