package com.example.myapplicationnewsapp.data.di

import com.example.myapplicationnewsapp.data.remote.api.ApiService
import com.example.myapplicationnewsapp.data.remote.repository.DataSource
import com.example.myapplicationnewsapp.data.remote.repository.RemoteDataSource
import com.example.myapplicationnewsapp.utils.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [ApiServiceModule::class])
@InstallIn(SingletonComponent::class)
class DataSourceModule {
  @Singleton
  @Provides
  @Named(Const.REMOTE_DATASOURCE)
  fun provideRemoteDataSource(apiService: ApiService): DataSource {
    return RemoteDataSource(apiService)
  }
}