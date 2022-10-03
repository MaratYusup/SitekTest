package com.example.mobileclient.domain.repository

interface RepositoryAuth {

    suspend fun getUsers(imei: String)

    suspend fun authentication(
        imei: String,
        uid: String,
        pass: String,
        copyFromDevice: Boolean,
        nfc: String,
    )
}