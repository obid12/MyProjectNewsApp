package com.example.myapplicationnewsapp.domain.usecase

import androidx.paging.PagingData
import com.example.myapplicationnewsapp.domain.model.ArticleModel
import com.example.myapplicationnewsapp.domain.repo.Repository
import com.example.myapplicationnewsapp.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCaseImplementation @Inject constructor(private val repository: Repository) : UseCase {
  override suspend fun getAllNewsByCategory(
    category: String,
    coroutine: CoroutineScope
  ): Flow<PagingData<ArticleModel>> {
    return repository.getAllNewsByCategory(category, coroutine)
  }

  override suspend fun getAllNewsByPopularityFirst(
    language: String,
    sortBy: String
  ): Flow<Resource<ArticleModel>> {
    return repository.getAllNewsByPopularityFirst(language, sortBy)
  }

}