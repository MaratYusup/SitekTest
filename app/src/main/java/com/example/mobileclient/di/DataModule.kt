package com.example.mobileclient.di

import com.example.mobileclient.data.network.ApiFactory
import com.example.mobileclient.data.network.ApiService
import com.example.mobileclient.data.repository.RepositoryAuthImpl
import com.example.mobileclient.domain.repository.RepositoryAuth
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    @Binds
    @ApplicationScope
    fun bindsRepositoryAuthImpl(impl: RepositoryAuthImpl): RepositoryAuth

    companion object {
        @Provides
        @ApplicationScope
        fun providesApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}