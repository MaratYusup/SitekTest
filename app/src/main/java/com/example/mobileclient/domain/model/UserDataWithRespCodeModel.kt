package com.example.mobileclient.domain.model

data class UserDataWithRespCodeModel (
    var responseCode: Int = -1,
    var userDataModelLists: List<UserDataModel?>? = listOf<UserDataModel>(),
)