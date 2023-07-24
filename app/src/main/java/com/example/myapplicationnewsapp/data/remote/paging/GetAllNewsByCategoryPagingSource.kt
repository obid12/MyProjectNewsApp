package com.example.myapplicationnewsapp.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.myapplicationnewsapp.data.remote.repository.DataSource
import com.example.myapplicationnewsapp.data.remote.response.NewsResponse
import com.example.myapplicationnewsapp.domain.model.ArticleModel

class GetAllNewsByCategoryPagingSource(
  private val remoteDataSource: DataSource,
  private val category: String
) :
  PagingSource<Int, ArticleModel>() {

  override fun getRefreshKey(state: PagingState<Int, ArticleModel>): Int? {
    return state.anchorPosition?.let { anchorPosition ->
      state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
        ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
    }
  }

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleModel> {
    val page = params.key ?: STARTING_PAGE_INDEX
    return try {
      val response =
        remoteDataSource.getAllNewsByCategory(
          LANGUAGE,
          category,
          page = page, 10
        )
      val data = NewsResponse.transform(response)
      LoadResult.Page(
        data = data.articles,
        prevKey = null,
        nextKey = if (data.articles.isEmpty()) null else page + 1
      )
    } catch (exception: Exception) {
      return LoadResult.Error(exception)
    }
  }

  companion object {
    const val STARTING_PAGE_INDEX = 0
    const val LANGUAGE = "en"
  }
}