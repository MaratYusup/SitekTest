package com.example.mobileclient.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileclient.domain.usecase.CheckPasswordFieldUseCase
import com.example.mobileclient.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FrSignInVM @Inject constructor(
    private val checkPasswordFieldUseCase: CheckPasswordFieldUseCase,
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {

    fun getUsers(){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getUsersUseCase.execute()
            }
        }
    }

//    private var _resultCheckUserName = MutableLiveData<Int?>()
//    var resultCheckUserName: LiveData<Int?> = _resultCheckUserName
//
//    private var _resultCheckPassword = MutableLiveData<Int?>()
//    var resultCheckPassword: LiveData<Int?> = _resultCheckPassword
//
//    private var _accessAllow = MutableLiveData<Boolean>()
//    var accessAllow: LiveData<Boolean> = _accessAllow
//
//
//    fun checkLogin(userName: String) {
//        val textEditHandlerTemp = checkAuthLoginFieldUseCase.execute(userName)
//        _resultCheckUserName.value = checkAuthFieldForCorrectness(textEditHandlerTemp)
//    }
//
//    fun checkPassword(password: String) {
//        val textEditHandlerTemp = checkAuthPasswordFieldUseCase.execute(password)
//        _resultCheckPassword.value = checkAuthFieldForCorrectness(textEditHandlerTemp)
//    }
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