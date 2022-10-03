package com.example.mobileclient.presentation.app

import android.app.Application
import com.example.mobileclient.di.DaggerApplicationComponent

class MobileClientApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}