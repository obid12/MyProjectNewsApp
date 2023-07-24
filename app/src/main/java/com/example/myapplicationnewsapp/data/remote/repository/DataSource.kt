package com.example.myapplicationnewsapp.data.remote.repository

import com.example.myapplicationnewsapp.data.remote.response.NewsResponse
import com.example.myapplicationnewsapp.domain.model.ArticleModel
import com.example.myapplicationnewsapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DataSource {
  suspend fun getAllNewsByCategory(
    language: String,
    category: String,
    page: Int,
    pageSize: Int
  ): NewsResponse

  suspend fun getAllNewsByPopularity(
    language: String,
    sortBy: String,
    page: Int,
    pageSize: Int
  ): NewsResponse

  suspend fun getAllNewsByPopularityFirst(
    language: String,
    sortBy: String
  ): Flow<Resource<ArticleModel>>
}