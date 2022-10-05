package com.example.mobileclient.data.mapper

import androidx.room.ColumnInfo
import com.example.mobileclient.data.database.UserAuthDataModelDb
import com.example.mobileclient.data.network.model.UserAuthDataModelDto
import com.example.mobileclient.data.network.model.UserDataModelDto
import com.example.mobileclient.domain.model.UserAuthDataModel
import com.example.mobileclient.domain.model.UserDataModel
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapUserDataModelDtoToEntity(userDataModelDtoList: List<UserDataModelDto?>?): List<UserDataModel>? {

        var userDataModelLists: List<UserDataModel?>? = userDataModelDtoList?.map { userDataDto ->
            userDataDto?.let {
                UserDataModel(
                    user = userDataDto?.user,
                    uid = userDataDto?.uid,
                    language = userDataDto?.language,
                )
            }
        }
        userDataModelLists = userDataModelLists?.filterNotNull()
        return userDataModelLists
    }

    fun mapUserAuthDataModelDtoToDb(
        userAuthDataModelDto: UserAuthDataModelDto?,
        user: String?,
        uid: String?,
    ): UserAuthDataModelDb? {

        return UserAuthDataModelDb(
            user = user,
            uid = uid,
            response = userAuthDataModelDto?.response,
            continueWork = userAuthDataModelDto?.continueWork,
            photoHash  = userAuthDataModelDto?.photoHash,
            currentDate = userAuthDataModelDto?.currentDate,
        )
    }

    fun mapUserAuthDataModelDbToDto(userAuthDataModelDb: UserAuthDataModelDb?): UserAuthDataModel? {

        return UserAuthDataModel(
            user = userAuthDataModelDb?.user ?: "",
            uid = userAuthDataModelDb?.uid ?: "",
            response = userAuthDataModelDb?.response ?: false,
            continueWork = userAuthDataModelDb?.continueWork ?: false,
            photoHash  = userAuthDataModelDb?.photoHash ?: "",
            currentDate = userAuthDataModelDb?.currentDate ?: "",
        )
    }
}