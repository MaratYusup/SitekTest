package com.example.mobileclient.domain.usecase

import com.example.mobileclient.domain.model.TextEditHandler
import javax.inject.Inject

class CheckLoginFieldUseCase @Inject constructor() {

    fun execute(login: String): TextEditHandler {
//        return if ((text.matches(Regex("""[\u0021-\u007A]{1,}""")))
        return if (login.isNotEmpty()){
            TextEditHandler.Ok()
        } else {
            TextEditHandler.ErrorLogin()
        }
    }
}