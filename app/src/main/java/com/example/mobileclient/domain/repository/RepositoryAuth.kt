package com.example.mobileclient.domain.repository

import com.example.mobileclient.domain.model.UserDataWithRespCode

interface RepositoryAuth {

    suspend fun getUsersList(imei: String): UserDataWithRespCode

    suspend fun authentication(
        imei: String,
        uid: String,
        pass: String,
        copyFromDevice: Boolean,
        nfc: String,
    )
}