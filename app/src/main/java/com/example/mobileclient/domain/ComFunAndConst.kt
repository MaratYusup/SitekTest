package com.example.mobileclient.domain

import com.example.mobileclient.R
import com.example.mobileclient.domain.model.TextEditHandler

object ComFunAndConst {

    public fun checkAuthFieldForCorrectness(textEditHandler: TextEditHandler): Int?{
        return when (textEditHandler) {
            is TextEditHandler.Ok -> null
            is TextEditHandler.ErrorLogin -> R.string.wrong_login_field_error
            is TextEditHandler.ErrorPassword-> R.string.wrong_password_field_error
            else -> null
        }
    }

    public fun checkSignInResponseCode(responseCode: Int): Int?{
        return when (responseCode) {
            200 -> null
            400 -> R.string.token_400_error
            else -> R.string.error_try_later
        }
    }
}