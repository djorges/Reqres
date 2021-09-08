package com.example.reqres.di

import com.example.reqres.data.repositories.MainRepositoryImpl
import com.example.reqres.domain.repositories.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class BindModule {
    @Binds
    abstract fun bindReqresRepo(
        mainRepositoryImpl: MainRepositoryImpl
    ): MainRepository
}