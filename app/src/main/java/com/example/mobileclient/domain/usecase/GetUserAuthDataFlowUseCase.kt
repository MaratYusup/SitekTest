package com.example.mobileclient.domain.usecase

import com.example.mobileclient.domain.model.UserAuthDataModel
import com.example.mobileclient.domain.repository.RepositoryAuth
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserAuthDataFlowUseCase @Inject constructor(
    private val repository: RepositoryAuth
) {
    fun execute(uid: String,): Flow<UserAuthDataModel?> {
        return repository.getUserAuthFlowFromDb(uid)
    }
}