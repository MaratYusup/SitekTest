package com.example.mobileclient.data.mapper

import com.example.mobileclient.data.network.model.UserDataDto
import com.example.mobileclient.domain.model.UserData
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapUserDataDtoToEntity(userDataDtoList: List<UserDataDto?>?): List<UserData>? {

        var userDataList: List<UserData?>? = userDataDtoList?.map { userDataDto ->
            userDataDto?.let {
                UserData(
                    user = userDataDto?.user,
                    uid = userDataDto?.uid,
                    language = userDataDto?.language,
                )
            }
        }
        userDataList = userDataList?.filterNotNull()
        return userDataList

    }
}