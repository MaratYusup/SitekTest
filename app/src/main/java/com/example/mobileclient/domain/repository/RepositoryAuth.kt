package com.example.mobileclient.domain.repository

import com.example.mobileclient.domain.model.UserAuthDataModel
import com.example.mobileclient.domain.model.UserDataWithRespCodeModel
import kotlinx.coroutines.flow.Flow

interface RepositoryAuth {

    suspend fun getUsersList(imei: String): UserDataWithRespCodeModel

    suspend fun authentication(
        imei: String,
        user: String,
        uid: String,
        pass: String,
        copyFromDevice: Boolean,
        nfc: String,
    ): Int

    suspend fun getUserAuthFromDb(uid: String): UserAuthDataModel

    fun getUserAuthFlowFromDb(uid: String): Flow<UserAuthDataModel?>
}