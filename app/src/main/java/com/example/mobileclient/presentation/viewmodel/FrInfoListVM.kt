package com.example.mobileclient.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mobileclient.di.UidQualifier
import com.example.mobileclient.domain.model.UserAuthDataInfo
import com.example.mobileclient.domain.model.UserAuthDataModel
import com.example.mobileclient.domain.usecase.GetUserAuthDataFlowUseCase
import javax.inject.Inject

class FrInfoListVM @Inject constructor(
    @UidQualifier val uid: String,
    private val application: Application,
    private val getUserAuthDataFlowUseCase: GetUserAuthDataFlowUseCase,
) : ViewModel() {

    var userAuthData = getUserAuthDataFlowUseCase.execute(uid).asLiveData()

    fun createUserAuthDataInfo(userAuthDataModel: UserAuthDataModel): List<UserAuthDataInfo> {
        val userAuthDataInfoList = mutableListOf<UserAuthDataInfo>()
        userAuthDataInfoList.add(
            UserAuthDataInfo(
                title = "ContinueWork",
                text = (userAuthDataModel.continueWork ?: false).toString()
            )
        )
        userAuthDataInfoList.add(
            UserAuthDataInfo(
                title = "Response",
                text = (userAuthDataModel.response ?: false).toString()
            )
        )
        userAuthDataInfoList.add(
            UserAuthDataInfo(
                title = "PhotoHash",
                text = userAuthDataModel.photoHash ?: ""
            )
        )
        userAuthDataInfoList.add(
            UserAuthDataInfo(
                title = "CurrentDate",
                text = userAuthDataModel.currentDate ?: ""
            )
        )
        return userAuthDataInfoList
    }
}