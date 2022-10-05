package com.example.mobileclient.domain.usecase

import com.example.mobileclient.domain.model.TextEditHandler
import javax.inject.Inject

class CheckPasswordFieldUseCase @Inject constructor() {

    fun execute(password: String): TextEditHandler {
//        return if ((text.matches(Regex("""[\u0021-\u007A]{1,}""")))
//        return if (password.isNotEmpty()){
//            TextEditHandler.Ok()
//        } else {
//            TextEditHandler.ErrorPassword()
//        }
        return TextEditHandler.Ok()
    }
}