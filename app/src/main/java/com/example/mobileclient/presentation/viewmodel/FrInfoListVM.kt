package com.example.mobileclient.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mobileclient.di.UidQualifier
import com.example.mobileclient.domain.usecase.GetUserAuthDataFlowUseCase
import javax.inject.Inject

class FrInfoListVM @Inject constructor(
    @UidQualifier val uid: String,
    private val application: Application,
    private val getUserAuthDataFlowUseCase: GetUserAuthDataFlowUseCase,
) : ViewModel() {

    var userAuthData = getUserAuthDataFlowUseCase.execute(uid).asLiveData()
}