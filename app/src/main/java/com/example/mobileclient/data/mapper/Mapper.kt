package com.example.mobileclient.data.mapper

import com.example.mobileclient.data.network.model.UserDataModelDto
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
}