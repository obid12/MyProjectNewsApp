package com.example.myapplicationnewsapp.domain.repo

import androidx.paging.PagingData
import com.example.myapplicationnewsapp.domain.model.ArticleModel
import com.example.myapplicationnewsapp.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface Repository {
  suspend fun getAllNewsByCategory(
    category: String,
    coroutine: CoroutineScope
  ): Flow<PagingData<ArticleModel>>

  suspend fun getAllNewsByPopularityFirst(
    language: String,
    sortBy: String
  ): Flow<Resource<ArticleModel>>
}