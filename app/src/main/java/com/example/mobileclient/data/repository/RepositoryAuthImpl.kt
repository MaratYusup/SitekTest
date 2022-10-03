package com.example.mobileclient.data.repository

import android.util.Log
import com.example.mobileclient.data.mapper.Mapper
import com.example.mobileclient.data.network.ApiService
import com.example.mobileclient.domain.repository.RepositoryAuth
import javax.inject.Inject

class RepositoryAuthImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: Mapper,
) : RepositoryAuth {

    override suspend fun getUsers(imei: String) {
        val response = apiService.getUsers(imei = imei)

        try {
            Log.i("responceCode", response.code().toString())
            Log.i("responceBody", response.body().toString())
        } catch (e: Exception) {
        }
    }

    override suspend fun authentication(
        imei: String,
        uid: String,
        pass: String,
        copyFromDevice: Boolean,
        nfc: String
    ) {
        val response = apiService.authentication(
            imei = imei,
            uid = uid,
            pass = pass,
            copyFromDevice = copyFromDevice,
            nfc = nfc,
        )

        try {
            Log.i("responceCode", response.code().toString())
            Log.i("responceBody", response.body().toString())
        } catch (e: Exception) {
        }
    }
}