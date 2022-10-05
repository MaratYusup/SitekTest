package com.example.mobileclient.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileclient.domain.ComFunAndConst.checkAuthFieldForCorrectness
import com.example.mobileclient.domain.ComFunAndConst.checkSignInResponseCode
import com.example.mobileclient.domain.model.UserDataModel
import com.example.mobileclient.domain.model.UserDataWithRespCodeModel
import com.example.mobileclient.domain.usecase.AuthenticationUseCase
import com.example.mobileclient.domain.usecase.CheckLoginFieldUseCase
import com.example.mobileclient.domain.usecase.CheckPasswordFieldUseCase
import com.example.mobileclient.domain.usecase.GetUsersListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FrSignInVM @Inject constructor(
    private val authenticationUseCase: AuthenticationUseCase,
    private val checkLoginFieldUseCase: CheckLoginFieldUseCase,
    private val checkPasswordFieldUseCase: CheckPasswordFieldUseCase,
    private val getUsersListUseCase: GetUsersListUseCase,
) : ViewModel() {

    private var _userDataList = MutableLiveData<UserDataWithRespCodeModel>()
    var userDataList: LiveData<UserDataWithRespCodeModel> = _userDataList

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
        userDataModel: UserDataModel?,
        spinnerText: String?
    ): UserDataModel {
        var newUserdata = UserDataModel()
        if (userDataModel?.user?.lowercase()?.trim() == spinnerText?.lowercase()?.trim()) {
            return userDataModel ?: newUserdata
        }

        if (userDataModel?.user != spinnerText) {
            userDataList.value?.userDataModelLists?.map {
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


    fun authentication(user: String, uid: String, password: String) {
        if ((_resultCheckLogin.value == null) && (_resultCheckPassword.value == null)) {

            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    val userAuthResp = authenticationUseCase.execute(user, uid, password)
                    _resultCheckPassword.postValue(checkSignInResponseCode(userAuthResp))
                    _accessAllow.postValue(userAuthResp == 200)
                }
            }
        }
    }
}