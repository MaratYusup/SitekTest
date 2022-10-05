package com.example.mobileclient.di

import com.example.mobileclient.presentation.fragment.FrInfoList
import com.example.mobileclient.presentation.fragment.FrSignIn
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
    modules = [ViewModelModule::class,]
)

interface FragmentComponent {

    fun inject (fragment: FrInfoList)
    fun inject (fragment: FrSignIn)

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance @UidQualifier uid: String = "",
        ): FragmentComponent
    }
}