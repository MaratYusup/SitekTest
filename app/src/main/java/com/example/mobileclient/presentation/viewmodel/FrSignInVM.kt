package com.example.mobileclient.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileclient.domain.ComFunAndConst.checkAuthFieldForCorrectness
import com.example.mobileclient.domain.model.UserData
import com.example.mobileclient.domain.model.UserDataWithRespCode
import com.example.mobileclient.domain.usecase.CheckLoginFieldUseCase
import com.example.mobileclient.domain.usecase.CheckPasswordFieldUseCase
import com.example.mobileclient.domain.usecase.GetUsersListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FrSignInVM @Inject constructor(
    private val application: Application,
    private val checkLoginFieldUseCase: CheckLoginFieldUseCase,
    private val checkPasswordFieldUseCase: CheckPasswordFieldUseCase,
    private val getUsersListUseCase: GetUsersListUseCase,
) : ViewModel() {

    private var _userDataList = MutableLiveData<UserDataWithRespCode>()
    var userDataList: LiveData<UserDataWithRespCode> = _userDataList

    private var _resultCheckLogin = MutableLiveData<Int?>()
    var resultCheckLogin: LiveData<Int?> = _resultCheckLogin

    private var _resultCheckPassword = MutableLiveData<Int?>()
    var resultCheckPassword: LiveData<Int?> = _resultCheckPassword

    private var _accessAllow = MutableLiveData<Boolean>()
    var accessAllow: LiveData<Boolean> = _accessAllow

    init {
        _accessAllow.value = false
    }

    fun getUsersList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _userDataList.postValue(getUsersListUseCase.execute())
            }
        }
    }

    fun compareLastSelectedUserDataAndSpinnerText(
        userData: UserData?,
        spinnerText: String?
    ): UserData {
        var newUserdata = UserData()
        if (userData?.user?.lowercase()?.trim() == spinnerText?.lowercase()?.trim()) {
            return userData ?: newUserdata
        }

        if (userData?.user != spinnerText) {
            userDataList.value?.userDataList?.map {
                if (it?.user?.lowercase()?.trim() == spinnerText?.lowercase()?.trim()) {
                    return it ?: newUserdata
                }
            }
        }
        return newUserdata
    }


    fun checkLogin(userName: String) {
        val textEditHandlerTemp = checkLoginFieldUseCase.execute(userName)
        _resultCheckLogin.value = checkAuthFieldForCorrectness(textEditHandlerTemp)
    }

    fun checkPassword(password: String) {
        val textEditHandlerTemp = checkPasswordFieldUseCase.execute(password)
        _resultCheckPassword.value = checkAuthFieldForCorrectness(textEditHandlerTemp)
    }

//
//    fun signIn(userName: String, password: String) {
//        if ((_resultCheckUserName.value == null) && (_resultCheckPassword.value == null)) {
//
//            viewModelScope.launch {
//                val userAuthInfoTemp = signInUserUseCase.execute(UserAuth(userName, password))
//
//                if (userAuthInfoTemp.responseCode != 200)
//                    _resultCheckUserName.value = R.string.empty
//                else
//                    _accessAllow.value = true
//
//                _resultCheckPassword.value = checkSignInResponseCode(userAuthInfoTemp.responseCode)
//            }
//        }
//    }
}