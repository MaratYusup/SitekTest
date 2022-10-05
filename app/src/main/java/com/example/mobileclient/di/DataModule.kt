package com.example.mobileclient.di

import android.app.Application
import com.example.mobileclient.data.database.AppDatabase
import com.example.mobileclient.data.database.UserAuthDataModelDao
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

        @Provides
        @ApplicationScope
        fun providesUserAuthDataModelDao(application: Application): UserAuthDataModelDao {
            return AppDatabase.getInstance(application).userAuthDataModelDao
        }
    }
}