package com.example.mobileclient.data.repository

import android.util.Log
import com.example.mobileclient.data.database.UserAuthDataModelDao
import com.example.mobileclient.data.mapper.Mapper
import com.example.mobileclient.data.network.ApiService
import com.example.mobileclient.domain.model.UserAuthDataModel
import com.example.mobileclient.domain.model.UserDataWithRespCodeModel
import com.example.mobileclient.domain.repository.RepositoryAuth
import okhttp3.Credentials
import javax.inject.Inject

class RepositoryAuthImpl @Inject constructor(
    private val apiService: ApiService,
    private val userAuthDataModelDao: UserAuthDataModelDao,
    private val mapper: Mapper,
) : RepositoryAuth {

    override suspend fun getUsersList(imei: String): UserDataWithRespCodeModel {
        val header = Credentials.basic("http", "http")

        val response = try {
            apiService.getUsersList(header = header, imei = imei)
        } catch (e: Exception) {
            null
        }

        val userDataWithRespCodeModel = UserDataWithRespCodeModel()

        when (response?.code()) {
            200 -> { // Успешно
                val userDto = response.body()
                val userDataList = mapper.mapUserDataModelDtoToEntity(userDto?.users?.listUsers)
                userDataList?.let {
                    userDataWithRespCodeModel.userDataModelLists = userDataList
                }
                userDataWithRespCodeModel.responseCode = 200
            }
            else -> { // Ошибка
            }
        }
        return userDataWithRespCodeModel
    }

    override suspend fun authentication(
        imei: String,
        user: String,
        uid: String,
        pass: String,
        copyFromDevice: Boolean,
        nfc: String,
    ): Int {
        val header = Credentials.basic("http", "http")

        val response = try {
            apiService.authentication(
                header = header,
                imei = imei,
                uid = uid,
                pass = pass,
                copyFromDevice = copyFromDevice,
                nfc = nfc,
            )
        } catch (e: Exception) {
            null
        }

        when (response?.code()) {
            200 -> { // Успешно
                val userAuthDto = response.body()

                val userAuthDataModelDb = mapper.mapUserAuthDataModelDtoToDb(
                    userAuthDataModelDto = userAuthDto?.authentication,
                    user = user,
                    uid = uid,
                )

                userAuthDataModelDao.updateItemByUID(
                    userAuthDataModelDb = userAuthDataModelDb,
                    uid = uid,
                )
                return 200
            }
            202 -> { // неверный пароль
                return 202
            }
            else -> { // Ошибка
            }
        }
        return -1
    }

    override suspend fun getUserAuthFromDb(uid: String): UserAuthDataModel {
        return mapper.mapUserAuthDataModelDbToDto(userAuthDataModelDao.getItemByUid(uid = uid))
            ?: UserAuthDataModel()
    }
}