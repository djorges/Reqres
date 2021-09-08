package com.example.reqres.di

import com.example.reqres.data.api.ReqresService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ReqresModule {
    @Provides
    @Singleton
    fun provideService(): ReqresService {
        return Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ReqresService::class.java)
    }
    companion object{
        private const val API_URL:String = "https://reqres.in/api/"
    }
}