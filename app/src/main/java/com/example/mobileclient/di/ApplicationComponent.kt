package com.example.mobileclient.di

import android.app.Application
import com.example.mobileclient.presentation.fragment.FrInfoList
import com.example.mobileclient.presentation.fragment.FrSignIn
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component (
    modules = [
        DataModule::class,
    ]
)
interface ApplicationComponent {

    fun fragmentComponentFactory(): FragmentComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }

}
