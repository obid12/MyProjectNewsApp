package com.example.myapplicationnewsapp.data.di

import com.example.myapplicationnewsapp.data.di.network.NetworkModule
import com.example.myapplicationnewsapp.data.remote.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class ApiServiceModule {
  @Singleton
  @Provides
  fun provideApi(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
  }
}