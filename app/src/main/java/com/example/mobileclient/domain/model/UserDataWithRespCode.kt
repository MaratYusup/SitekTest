package com.example.mobileclient.domain.model

data class UserDataWithRespCode (
    var responseCode: Int = -1,
    var userDataList: List<UserData?>? = listOf<UserData>(),
)