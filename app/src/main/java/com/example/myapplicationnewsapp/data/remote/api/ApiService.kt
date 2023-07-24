package com.example.myapplicationnewsapp.data.remote.api

import com.example.myapplicationnewsapp.data.remote.response.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
  @GET("top-headlines")
  suspend fun getAllNewsByCategory(
    @Query("language")
    language: String,
    @Query("category")
    category: String,
    @Query("page")
    page: Int,
    @Query("pageSize")
    pageSize: Int,
  ): NewsResponse

  @GET("top-headlines")
  suspend fun getAllNewsByPopularityFirst(
    @Query("language")
    language: String,
    @Query("sortBy")
    sortBy: String
  ): Response<NewsResponse>

  @GET("top-headlines")
  suspend fun getAllNewsByPopularity(
    @Query("language")
    language: String,
    @Query("sortBy")
    sortBy: String,
    @Query("page")
    page: Int,
    @Query("pageSize")
    pageSize: Int,
  ): NewsResponse
}