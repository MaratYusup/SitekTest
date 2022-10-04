package com.example.mobileclient.domain.repository

import com.example.mobileclient.domain.model.UserDataWithRespCodeModel

interface RepositoryAuth {

    suspend fun getUsersList(imei: String): UserDataWithRespCodeModel

    suspend fun authentication(
        imei: String,
        uid: String,
        pass: String,
        copyFromDevice: Boolean,
        nfc: String,
    ): Int
}