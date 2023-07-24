package com.example.myapplicationnewsapp.domain.model

import java.sql.Timestamp

data class NewsModel(
  val status: String,
  val totalResults: Int,
  val articles: ArrayList<ArticleModel>
)

data class ArticleModel(
  val image: String,
  val title: String,
  val source: String,
  val time: Timestamp?,
  val url: String
)
