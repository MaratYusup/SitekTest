package com.example.mobileclient.domain.usecase

import com.example.mobileclient.domain.model.TextEditHandler
import javax.inject.Inject

class CheckPasswordFieldUseCase @Inject constructor() {

    fun execute(password: String): TextEditHandler {
        return if ((password.matches(Regex("""[\u0021-\u007A]{1,}""")))
        ) {
            TextEditHandler.Ok()
        } else {
            TextEditHandler.ErrorPassword()
        }
    }
}