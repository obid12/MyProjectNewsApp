package com.example.myapplicationnewsapp.data.di.network

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

  @Singleton
  @Provides
  fun provideRetrofit(okHttpClient: OkHttpClient, @ApplicationContext context: Context): Retrofit {
    return Retrofit.Builder().apply {
      addConverterFactory(GsonConverterFactory.create())
      client(okHttpClient)
      baseUrl("https://newsapi.org/v2/")
    }.build()
  }

  @Singleton
  @Provides
  fun provideOkHttp(requestInterceptor: RequestInterceptor): OkHttpClient =
    OkHttpClient.Builder().apply {
      connectTimeout(60, TimeUnit.SECONDS)
      writeTimeout(60, TimeUnit.SECONDS)
      readTimeout(60, TimeUnit.SECONDS)
      addInterceptor(requestInterceptor)
    }.build()

  @Provides
  fun provideRequestInterceptor(): RequestInterceptor = RequestInterceptor()


}