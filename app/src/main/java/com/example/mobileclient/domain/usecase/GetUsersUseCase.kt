package com.example.mobileclient.domain.usecase

import com.example.mobileclient.data.repository.RepositoryAuthImpl
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: RepositoryAuthImpl
) {
    suspend fun execute(){
        /*
        Для получения IMEI необходимо разрешение READ_PHONE_STATE ,
        а с Android 10 (SDK 29), теперь необходимо разрешение READ_PRIVILEGED_PHONE_STATE ,
        которое доступно только системным приложениям. Получается, c SDK 29, для не системных приложений,
        больше нет легального способа получить IMEI
         */
        val imei = "111111111111111"

        repository.getUsers(imei)
    }
}