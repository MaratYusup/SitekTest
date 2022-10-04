package com.example.mobileclient.domain.usecase

import com.example.mobileclient.data.repository.RepositoryAuthImpl
import com.example.mobileclient.domain.model.UserData
import com.example.mobileclient.domain.model.UserDataWithRespCode
import com.example.mobileclient.domain.repository.RepositoryAuth
import javax.inject.Inject

class GetUsersListUseCase @Inject constructor(
    private val repository: RepositoryAuth
) {
    suspend fun execute(): UserDataWithRespCode {
        /*
        Для получения IMEI необходимо разрешение READ_PHONE_STATE ,
        а с Android 10 (SDK 29), теперь необходимо разрешение READ_PRIVILEGED_PHONE_STATE ,
        которое доступно только системным приложениям. Получается, c SDK 29, для не системных приложений,
        больше нет легального способа получить IMEI
         */
        val imei = "111111111111111"
        return repository.getUsersList(imei)
    }
}