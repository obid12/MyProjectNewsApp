package com.example.myapplicationnewsapp.presentation.home.listnewsrecent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import com.example.myapplicationnewsapp.domain.model.ArticleModel
import com.example.myapplicationnewsapp.domain.usecase.UseCaseImplementation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ListNewsViewModel @Inject constructor(
  private val useCase: UseCaseImplementation
) : ViewModel() {

  suspend fun getListNewsRecent(category: String): Flow<PagingData<ArticleModel>> {
    return useCase.getAllNewsByCategory(category, viewModelScope)
      .map { paging ->
        paging.map {
          it
        }
      }
  }

}