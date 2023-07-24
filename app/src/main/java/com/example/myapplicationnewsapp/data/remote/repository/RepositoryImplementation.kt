package com.example.myapplicationnewsapp.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.myapplicationnewsapp.data.remote.paging.GetAllNewsByCategoryPagingSource
import com.example.myapplicationnewsapp.domain.model.ArticleModel
import com.example.myapplicationnewsapp.domain.repo.Repository
import com.example.myapplicationnewsapp.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
  private val remoteDataSource: DataSource
) : Repository {
  override suspend fun getAllNewsByCategory(
    category: String,
    coroutine: CoroutineScope
  ): Flow<PagingData<ArticleModel>> {
    return Pager(
      config = PagingConfig(10, prefetchDistance = 1),
      pagingSourceFactory = { GetAllNewsByCategoryPagingSource(remoteDataSource, category) }).flow
  }

  override suspend fun getAllNewsByPopularityFirst(
    language: String,
    sortBy: String
  ): Flow<Resource<ArticleModel>> {
    return remoteDataSource.getAllNewsByPopularityFirst(language, sortBy)
  }

}