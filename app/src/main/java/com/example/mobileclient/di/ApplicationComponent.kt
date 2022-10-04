package com.example.mobileclient.di

import android.app.Application
import com.example.mobileclient.presentation.fragment.FrAuthorization
import com.example.mobileclient.presentation.fragment.FrSignIn
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component (
    modules = [
        DataModule::class,
        ViewModelModule::class,
    ]
)
interface ApplicationComponent {

    fun inject (fragment: FrAuthorization)
    fun inject (fragment: FrSignIn)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }

}
