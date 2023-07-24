package com.example.myapplicationnewsapp.data.di

import com.example.myapplicationnewsapp.data.remote.repository.DataSource
import com.example.myapplicationnewsapp.data.remote.repository.RepositoryImplementation
import com.example.myapplicationnewsapp.domain.repo.Repository
import com.example.myapplicationnewsapp.utils.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [DataSourceModule::class])
@InstallIn(SingletonComponent::class)
class RepositoryModule {
  @Singleton
  @Provides
  fun provideRepository(
    @Named(Const.REMOTE_DATASOURCE) remoteDataSource: DataSource
  ): Repository {
    return RepositoryImplementation(remoteDataSource)
  }

}