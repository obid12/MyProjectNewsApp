package com.example.myapplicationnewsapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationnewsapp.domain.model.ArticleModel
import com.example.myapplicationnewsapp.domain.usecase.UseCaseImplementation
import com.example.myapplicationnewsapp.utils.Resource
import com.example.myapplicationnewsapp.utils.Resource.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val useCase: UseCaseImplementation
) : ViewModel() {

  private val _dataNewsPopularity =
    MutableStateFlow<Resource<ArticleModel?>>(Success(null))
  val dataNewsPopularity get() = _dataNewsPopularity

  fun getAllNewsByPopularityFirst() {
    viewModelScope.launch {
      useCase.getAllNewsByPopularityFirst("en", "popularity")
        .catch {
          _dataNewsPopularity.value = Resource.Error(it)
        }
        .collect {
          _dataNewsPopularity.value = it
        }
    }
  }
}