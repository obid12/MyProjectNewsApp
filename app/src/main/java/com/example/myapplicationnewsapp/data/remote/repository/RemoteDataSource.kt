package com.example.myapplicationnewsapp.data.remote.repository

import com.example.myapplicationnewsapp.data.remote.api.ApiService
import com.example.myapplicationnewsapp.data.remote.response.NewsResponse
import com.example.myapplicationnewsapp.domain.model.ArticleModel
import com.example.myapplicationnewsapp.utils.Resource
import com.example.myapplicationnewsapp.utils.Resource.Loading
import com.example.myapplicationnewsapp.utils.Resource.Success
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
  private val apiService: ApiService
) : DataSource {
  override suspend fun getAllNewsByCategory(
    language: String,
    category: String,
    page: Int,
    pageSize: Int
  ): NewsResponse {
    return apiService.getAllNewsByCategory(language, category, page, pageSize)
  }

  override suspend fun getAllNewsByPopularity(
    language: String,
    sortBy: String,
    page: Int,
    pageSize: Int
  ): NewsResponse {
    TODO("Not yet implemented")
  }

  override suspend fun getAllNewsByPopularityFirst(
    language: String,
    sortBy: String
  ): Flow<Resource<ArticleModel>> {
    return flow {
      emit(Loading)
      try {
        val response = apiService.getAllNewsByPopularityFirst(language, sortBy)
        response.body()?.let {
          val data = NewsResponse.transform(it).articles.take(1)
          data.map { data ->
            emit(Success(data))
          }
        } ?: kotlin.run {
          throw HttpException(response)
        }
      } catch (e: Throwable) {
        emit(Resource.Error(e))
      }
    }
  }

}