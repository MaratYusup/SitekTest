package com.example.mobileclient.domain.usecase

import com.example.mobileclient.domain.model.UserAuthDataModel
import com.example.mobileclient.domain.repository.RepositoryAuth
import javax.inject.Inject

class GetUserAuthDataUseCase @Inject constructor(
    private val repository: RepositoryAuth
) {
    suspend fun execute(uid: String,): UserAuthDataModel {
        return repository.getUserAuthFromDb(uid)
    }
}