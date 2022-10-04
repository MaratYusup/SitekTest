package com.example.mobileclient.domain.model

sealed class TextEditHandler() {

    class Ok(): TextEditHandler()

    class ErrorLogin(): TextEditHandler()

    class ErrorPassword(): TextEditHandler()
}