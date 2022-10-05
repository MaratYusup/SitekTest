package com.example.mobileclient.di

import androidx.lifecycle.ViewModel
import com.example.mobileclient.presentation.viewmodel.FrInfoListVM
import com.example.mobileclient.presentation.viewmodel.FrSignInVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FrSignInVM::class)
    fun bindFrAuthSignInVm(viewmodel: FrSignInVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FrInfoListVM::class)
    fun bindFrInfoListVm(viewmodel: FrInfoListVM): ViewModel

}