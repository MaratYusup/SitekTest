package com.example.mobileclient.data.repository

import android.util.Log
import com.example.mobileclient.data.mapper.Mapper
import com.example.mobileclient.data.network.ApiService
import com.example.mobileclient.data.network.model.UserDto
import com.example.mobileclient.domain.model.UserDataWithRespCode
import com.example.mobileclient.domain.repository.RepositoryAuth
import okhttp3.Credentials
import javax.inject.Inject

class RepositoryAuthImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: Mapper,
) : RepositoryAuth {

    override suspend fun getUsersList(imei: String): UserDataWithRespCode {
        val header = Credentials.basic("http", "http")

        val response = try {
            apiService.getUsersList(header = header, imei = imei,)
        } catch (e: Exception) {
            null
        }

        val userDataWithRespCode = UserDataWithRespCode()

        when (response?.code()) {
            200 -> { // Успешно
                val userDto = response.body()
                val userDataList = mapper.mapUserDataDtoToEntity(userDto?.users?.listUsers)
                userDataList?.let{
                    userDataWithRespCode.userDataList = userDataList
                }
                userDataWithRespCode.responseCode = 200
            }
            else -> { // Ошибка. При наличии списка кодов ошибок от сервера, можно выдавать сообщения
            }
        }
        return userDataWithRespCode
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