package com.example.myapplicationnewsapp.data.di.network

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class RequestInterceptor : Interceptor {
  override fun intercept(chain: Chain): Response {
    val newReq = chain.request().newBuilder().addHeader(
      "Authorization",
      "801ed4654c284823801d3625af4e7a68"
    ).build()

    return chain.proceed(newReq)
  }
}