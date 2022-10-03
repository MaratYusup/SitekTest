package com.example.mobileclient.di

import android.app.Application
import com.example.mobileclient.presentation.fragment.FrAuthorization
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component (
    modules = [
        DataModule::class,
    ]
)
interface ApplicationComponent {

    fun inject (fragment: FrAuthorization)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }

}
